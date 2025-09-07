package com.rj.expensemate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExpenseMateApplication

fun main(args: Array<String>) {
	runApplication<ExpenseMateApplication>(*args)
}
