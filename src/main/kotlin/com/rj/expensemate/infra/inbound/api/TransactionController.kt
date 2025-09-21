package com.rj.expensemate.infra.inbound.api

import com.rj.expensemate.core.ports.`in`.TransactionUseCase
import com.rj.expensemate.infra.inbound.api.model.request.TransactionRequest
import com.rj.expensemate.infra.inbound.api.model.response.TransactionResponse
import com.rj.expensemate.util.TransactionMapper
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(
    private val transactionUseCase: TransactionUseCase
) {

    @PostMapping
    fun addTransaction(@RequestBody request: TransactionRequest): TransactionResponse {
        val userId = SecurityContextHolder.getContext().authentication.principal as UUID
        val transaction = TransactionMapper.fromRequest(request, userId)
        return TransactionMapper.toResponse(transactionUseCase.addTransaction(transaction))
    }

    @GetMapping
    fun getTransactions(): List<TransactionResponse> {
        val userId = SecurityContextHolder.getContext().authentication.principal as UUID
        return transactionUseCase.getTransactions(userId).map { TransactionMapper.toResponse(it) }
    }

    @DeleteMapping("/{transactionId}")
    fun deleteTransaction(@PathVariable transactionId: UUID) {
        transactionUseCase.deleteTransaction(transactionId)
    }
}
