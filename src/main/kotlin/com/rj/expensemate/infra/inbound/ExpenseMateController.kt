package com.rj.expensemate.infra.inbound

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ExpenseMateController {
    @GetMapping("/api/secure/hello")
    fun hello(): String {
        return "Hello from secure endpoint!"
    }
}