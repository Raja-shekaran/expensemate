package com.rj.expensemate.util

import com.rj.expensemate.core.domain.model.Category
import com.rj.expensemate.infra.inbound.api.model.request.CategoryRequest
import com.rj.expensemate.infra.inbound.api.model.response.CategoryResponse
import java.util.*

object CategoryMapper {

    fun fromRequest(request: CategoryRequest, userId: UUID): Category {
        return Category(
            id = UUID.randomUUID(),
            userId = userId,
            name = request.name
        )
    }

    fun toResponse(category: Category): CategoryResponse {
        return CategoryResponse(
            id = category.id,
            userId = category.userId,
            name = category.name
        )
    }
}
