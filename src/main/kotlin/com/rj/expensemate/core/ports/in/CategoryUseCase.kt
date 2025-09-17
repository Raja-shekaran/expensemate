package com.rj.expensemate.core.ports.`in`

import com.rj.expensemate.core.domain.model.Category
import java.util.UUID

interface CategoryUseCase {
    fun createCategory(category: Category): Category
    fun getCategories(userId: UUID): List<Category>
    fun deleteCategory(categoryId: UUID)
}