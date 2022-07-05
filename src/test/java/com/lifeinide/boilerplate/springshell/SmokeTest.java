package com.lifeinide.boilerplate.springshell;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import com.lifeinide.boilerplate.springshell.test.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmokeTest extends AbstractIntegrationTest {

	@Autowired protected CurrencyRateRepository currencyRateRepository;

	@Test
	void testDataPopulated() {
		assertEquals(Currency.values().length, currencyRateRepository.count());
	}

}
