package com.rj.expensemate.util

import com.rj.expensemate.core.ports.out.TokenProviderPort
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil : TokenProviderPort {
    private val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    override fun generateToken(email: String): String {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 86400000))
            .signWith(secretKey)
            .compact()
    }
}
