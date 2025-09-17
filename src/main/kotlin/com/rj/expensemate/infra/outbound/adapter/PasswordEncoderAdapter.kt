package com.rj.expensemate.infra.outbound.adapter

import com.rj.expensemate.core.ports.out.PasswordEncoderPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderAdapter(
    private val delegate: PasswordEncoder
) : PasswordEncoderPort {
    override fun encode(raw: String): String = delegate.encode(raw)
    override fun matches(raw: String, encoded: String): Boolean = delegate.matches(raw, encoded)
}
