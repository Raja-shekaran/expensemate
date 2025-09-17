package com.rj.expensemate.core.ports.out

interface PasswordEncoderPort {
    fun encode(raw: String): String
    fun matches(raw: String, encoded: String): Boolean
}
