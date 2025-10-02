package com.rj.expensemate.infra.inbound.api

import com.rj.expensemate.core.ports.`in`.CategoryUseCase
import com.rj.expensemate.infra.inbound.api.model.request.CategoryRequest
import com.rj.expensemate.infra.inbound.api.model.response.CategoryResponse
import com.rj.expensemate.util.CategoryMapper
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
    private val categoryUseCase: CategoryUseCase
) {

    @PostMapping
    fun createCategory(@RequestBody request: CategoryRequest): CategoryResponse {
        val userId = SecurityContextHolder.getContext().authentication.principal as UUID
        val category = categoryUseCase.createCategory(
            CategoryMapper.fromRequest(request, userId)
        )
        return CategoryMapper.toResponse(category)
    }

    @GetMapping
    fun getCategories(): List<CategoryResponse> {
        val userId = SecurityContextHolder.getContext().authentication.principal as UUID
        return categoryUseCase.getCategories(userId).map { CategoryMapper.toResponse(it) }
    }

    @DeleteMapping("/{categoryId}")
    fun deleteCategory(@PathVariable categoryId: UUID) {
        categoryUseCase.deleteCategory(categoryId)
    }
}

