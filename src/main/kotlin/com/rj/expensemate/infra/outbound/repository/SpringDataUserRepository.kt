package com.rj.expensemate.infra.outbound.repository

import com.rj.expensemate.infra.outbound.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SpringDataUserRepository : JpaRepository<UserEntity, UUID> {
    fun findByEmail(email: String): UserEntity?
}
