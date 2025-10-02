package com.rj.expensemate.core.ports.`in`

import com.rj.expensemate.core.domain.model.Summary
import java.util.UUID

interface DashboardUseCase {
    fun getSummary(userId: UUID): Summary
}