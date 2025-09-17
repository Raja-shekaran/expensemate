package com.rj.expensemate.infra.outbound.adapter

import com.rj.expensemate.core.domain.model.User
import com.rj.expensemate.core.ports.out.UserRepositoryPort
import com.rj.expensemate.infra.outbound.entity.UserEntity
import com.rj.expensemate.infra.outbound.repository.SpringDataUserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(
    private val repo: SpringDataUserRepository
) : UserRepositoryPort {

    override fun findByEmail(email: String): User? =
        repo.findByEmail(email)?.toDomain()

    override fun save(user: User): User =
        repo.save(user.toEntity()).toDomain()

    private fun UserEntity.toDomain() = User(id, name, email, passwordHash, provider, providerId, createdAt, updatedAt)
    private fun User.toEntity() = UserEntity(id, name, email, passwordHash, provider, providerId, createdAt, updatedAt)
}
