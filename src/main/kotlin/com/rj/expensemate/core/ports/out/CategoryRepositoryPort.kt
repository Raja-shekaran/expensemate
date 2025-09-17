package com.rj.expensemate.core.ports.out

import com.rj.expensemate.core.domain.model.Category
import java.util.UUID

interface CategoryRepositoryPort {
    fun save(category: Category): Category
    fun findByUserId(userId: UUID): List<Category>
    fun deleteById(categoryId: UUID)
}