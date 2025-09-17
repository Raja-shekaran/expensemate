package com.rj.expensemate.infra.inbound.api

import com.rj.expensemate.core.ports.`in`.TransactionUseCase
import com.rj.expensemate.infra.inbound.api.model.request.TransactionRequest
import com.rj.expensemate.infra.inbound.api.model.response.TransactionResponse
import com.rj.expensemate.util.TransactionMapper
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(
    private val transactionUseCase: TransactionUseCase
) {

    @PostMapping
    fun addTransaction(@RequestBody request: TransactionRequest): TransactionResponse {
        val transaction = transactionUseCase.addTransaction(
            TransactionMapper.fromRequest(request)
        )
        return TransactionMapper.toResponse(transaction)
    }

    @GetMapping("/{userId}")
    fun getTransactions(@PathVariable userId: UUID): List<TransactionResponse> {
        return transactionUseCase.getTransactions(userId)
            .map { TransactionMapper.toResponse(it) }
    }

    @DeleteMapping("/{transactionId}")
    fun deleteTransaction(@PathVariable transactionId: UUID) {
        transactionUseCase.deleteTransaction(transactionId)
    }
}
