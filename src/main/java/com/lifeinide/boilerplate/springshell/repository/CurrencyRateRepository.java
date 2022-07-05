package com.lifeinide.boilerplate.springshell.repository;

import com.lifeinide.boilerplate.springshell.domain.CurrencyRate;
import com.lifeinide.boilerplate.springshell.enums.Currency;
import org.springframework.lang.NonNull;

public interface CurrencyRateRepository extends AbstractRepository<CurrencyRate> {

	CurrencyRate findByCurrency(@NonNull Currency currency);

}
