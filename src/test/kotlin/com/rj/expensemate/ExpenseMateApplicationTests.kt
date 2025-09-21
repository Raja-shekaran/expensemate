package com.rj.expensemate

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(JwtTestConfig::class)
class ExpenseMateApplicationTests {

	@Test
	fun contextLoads() {
	}

}
