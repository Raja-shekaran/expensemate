package com.rj.expensemate

import com.rj.expensemate.util.JwtUtil
import org.mockito.Mockito
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean


@TestConfiguration
class JwtTestConfig {
    @Bean
    fun jwtUtil(): JwtUtil? {
        return Mockito.mock<JwtUtil?>(JwtUtil::class.java)
    }
}
