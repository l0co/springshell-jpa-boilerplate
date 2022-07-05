package com.lifeinide.boilerplate.springshell.service;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Lukasz Frankowski
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CurrencyRateService {
	
	private final CurrencyRateRepository repository;

	public void updateRate(@NonNull Currency currency, @NonNull BigDecimal rate) {
		repository.findByCurrency(currency).setRate(rate);
	}

}
