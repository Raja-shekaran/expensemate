package com.rj.expensemate.infra.inbound.api

import com.rj.expensemate.core.domain.model.Summary
import com.rj.expensemate.core.ports.`in`.DashboardUseCase
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/dashboard")
class DashboardController(
    private val dashboardUseCase: DashboardUseCase
) {
    @GetMapping("/summary")
    fun getSummary(): Summary {
        val userId = SecurityContextHolder.getContext().authentication.principal as UUID
        return dashboardUseCase.getSummary(userId)
    }
}
