package com.rj.expensemate.infra.outbound.repository

import com.rj.expensemate.infra.outbound.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SpringDataCategoryRepository : JpaRepository<CategoryEntity, UUID> {
    fun findByUserId(userId: UUID): List<CategoryEntity>
}
