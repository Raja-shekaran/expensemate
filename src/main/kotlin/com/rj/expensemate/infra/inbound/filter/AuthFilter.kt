package com.rj.expensemate.infra.inbound.filter

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.security.Key


@Component
class JwtAuthFilter : OncePerRequestFilter() {
    private val secret = "mysecretkeymysecretkeymysecretkey" // 🔒 same as in JwtService

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authHeader.substring(7)
        try {
            val key: Key = Keys.hmacShaKeyFor(secret.toByteArray())
            val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()

            val username = claims.getSubject()

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                val authToken =
                    UsernamePasswordAuthenticationToken(username, null, mutableListOf<GrantedAuthority?>())
                authToken.setDetails(WebAuthenticationDetailsSource().buildDetails(request))
                SecurityContextHolder.getContext().setAuthentication(authToken)
            }
        } catch (e: Exception) {
            println("Invalid JWT: " + e.message)
        }

        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        val path = request.servletPath
        return path.startsWith("/api/v1/auth/")
    }

}
