package com.lifeinide.boilerplate.springshell.test;

import com.lifeinide.boilerplate.springshell.domain.CurrencyRate;
import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import com.lifeinide.boilerplate.springshell.service.CurrencyRateService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
class CurrencyTest extends AbstractIntegrationTest {

	@Autowired private CurrencyRateRepository repository;
	@Autowired private CurrencyRateService service;

	@Test @Order(1)
	void testDataPopulated() {
		assertEquals(Currency.values().length, repository.count());
	}

	@Test @Transactional @Order(2)
	void testChangeRate() {
		CurrencyRate rate = repository.findByCurrency(Currency.USD);
		assertEquals(0, BigDecimal.ONE.compareTo(rate.getRate()));
		BigDecimal newRate = new BigDecimal("2.0000");
		service.setRate(Currency.USD, newRate);
		assertEquals(0, newRate.compareTo(rate.getRate()));
	}

	@Test @Transactional @Order(3)
	void testTransactionalWorks() { // is testChangeRate() rolled back?
		CurrencyRate rate = repository.findByCurrency(Currency.USD);
		assertEquals(0, BigDecimal.ONE.compareTo(rate.getRate()));
	}

}
