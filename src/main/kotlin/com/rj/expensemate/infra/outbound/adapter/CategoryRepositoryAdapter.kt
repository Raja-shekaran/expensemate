package com.rj.expensemate.infra.outbound.adapter

import com.rj.expensemate.core.domain.model.Category
import com.rj.expensemate.core.ports.out.CategoryRepositoryPort
import com.rj.expensemate.infra.outbound.entity.CategoryEntity
import com.rj.expensemate.infra.outbound.repository.SpringDataCategoryRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoryRepositoryAdapter(
    private val jpaRepo: SpringDataCategoryRepository
) : CategoryRepositoryPort {

    override fun save(category: Category): Category {
        val entity = CategoryEntity(
            id = category.id,
            userId = category.userId,
            name = category.name
        )
        return jpaRepo.save(entity).let {
            Category(it.id, it.userId, it.name)
        }
    }

    override fun findByUserId(userId: UUID): List<Category> =
        jpaRepo.findByUserId(userId).map {
            Category(it.id, it.userId, it.name)
        }

    override fun deleteById(categoryId: UUID) {
        jpaRepo.deleteById(categoryId)
    }
}
