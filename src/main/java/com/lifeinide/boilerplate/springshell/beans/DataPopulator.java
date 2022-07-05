package com.lifeinide.boilerplate.springshell.beans;

import com.lifeinide.boilerplate.springshell.domain.CurrencyRate;
import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author Lukasz Frankowski
 */
@Component
@RequiredArgsConstructor
@Transactional
public class DataPopulator implements ApplicationRunner {

	private final CurrencyRateRepository currencyRateRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (shouldPopulate()) {
			populateCurrencies();
		}
	}

	public boolean shouldPopulate() {
		return currencyRateRepository.count() == 0;
	}

	public void populateCurrencies() {
		Arrays.stream(Currency.values()).forEach(currency -> currencyRateRepository.save(
			CurrencyRate.builder()
				.currency(currency)
				.build()
		));
	}

}
