package com.rj.expensemate.util

import com.rj.expensemate.core.domain.model.Transaction
import com.rj.expensemate.infra.inbound.api.model.response.TransactionResponse
import com.rj.expensemate.infra.inbound.api.model.request.TransactionRequest
import java.util.UUID

object TransactionMapper {

    fun toResponse(transaction: Transaction): TransactionResponse =
        TransactionResponse(
            id = transaction.id,
            userId = transaction.userId,
            amount = transaction.amount,
            type = transaction.type,
            categoryId = transaction.categoryId,
            date = transaction.date,
            notes = transaction.notes
        )

    fun fromRequest(request: TransactionRequest, userId: UUID): Transaction =
        Transaction(
            userId = userId,
            amount = request.amount,
            type = request.type,
            categoryId = request.categoryId,
            date = request.date,
            notes = request.notes
        )
}
