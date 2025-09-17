package com.rj.expensemate.core.ports.out

import com.rj.expensemate.core.domain.model.User

interface UserRepositoryPort {
    fun findByEmail(email: String): User?
    fun save(user: User): User
}
