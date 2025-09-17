package com.rj.expensemate.core.domain.service

import com.rj.expensemate.core.domain.model.Category
import com.rj.expensemate.core.ports.`in`.CategoryUseCase
import com.rj.expensemate.core.ports.out.CategoryRepositoryPort
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(
    private val categoryRepository: CategoryRepositoryPort
) : CategoryUseCase {

    override fun createCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    override fun getCategories(userId: UUID): List<Category> {
        return categoryRepository.findByUserId(userId)
    }

    override fun deleteCategory(categoryId: UUID) {
        categoryRepository.deleteById(categoryId)
    }
}
