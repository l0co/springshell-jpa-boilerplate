package com.lifeinide.boilerplate.springshell.beans;

import com.lifeinide.boilerplate.springshell.domain.CurrencyRate;
import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.shell.jline.ScriptShellRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author Lukasz Frankowski
 */
@Component
@RequiredArgsConstructor
@Transactional
@Order(DataPopulator.PRECEDENCE)
@Slf4j
public class DataPopulator implements ApplicationRunner {

	public static final int PRECEDENCE = ScriptShellRunner.PRECEDENCE - 50;

	private final CurrencyRateRepository currencyRateRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (shouldPopulate()) {
			log.info("Populating initial data");
			populateCurrencies();
		} else
			log.debug("Data already populated, skipping");
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
