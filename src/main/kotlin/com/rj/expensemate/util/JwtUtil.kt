package com.rj.expensemate.util

import com.rj.expensemate.core.ports.out.TokenProviderPort
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtUtil(
    @Value("\${jwt.secret}") private val secret: String,
    @Value("\${jwt.expiration}") private val expiration: Long
) : TokenProviderPort {

    private val key: Key =  Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))

    override fun generateToken(userId: UUID): String {
        val now = Date()
        val expiry = Date(now.time + expiration)
        return Jwts.builder()
            .setSubject(userId.toString())
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            getUserIdFromToken(token) != null
        } catch (e: Exception) {
            false
        }
    }

    fun getUserIdFromToken(token: String): UUID? {
        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.removePrefix("Bearer ").trim())
                .body
            UUID.fromString(claims.subject)
        } catch (e: Exception) {
            null
        }
    }
}

