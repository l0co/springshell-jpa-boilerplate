package com.lifeinide.boilerplate.springshell.shell.currency;

import com.lifeinide.boilerplate.springshell.display.IPropertyRenderer;
import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.repository.CurrencyRateRepository;
import com.lifeinide.boilerplate.springshell.service.CurrencyRateService;
import com.lifeinide.boilerplate.springshell.shell.ShellGroups;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;

/**
 * @author Lukasz Frankowski
 */
@ShellComponent
@ShellCommandGroup(ShellGroups.CURRENCY)
@RequiredArgsConstructor
public class CurrencyRateShell {

	private final CurrencyRateRepository repository;
	private final CurrencyRateService service;
	private final IPropertyRenderer propertyRenderer;

	@ShellMethod("Lists all currency rates or displays a single currency rate.")
	public String currencyRateList(
		@ShellOption(arity = 1, help = "Currency to display.", defaultValue = ShellOption.NULL) Currency c
	) {
		if (c != null)
			return propertyRenderer.render(repository.findByCurrency(c));
		else
			return propertyRenderer.render(repository.findAll());
	}

	@ShellMethod("Sets or displays currency rate.")
	public String currencyRate(
		@ShellOption(arity = 1, help = "Currency to display.") Currency c,
		@ShellOption(arity = 1, help = "Rate to set.", defaultValue = ShellOption.NULL) BigDecimal r
	) {
		if (r != null)
			service.setRate(c, r);
		return repository.findByCurrency(c).getRate().toString();
	}

}
