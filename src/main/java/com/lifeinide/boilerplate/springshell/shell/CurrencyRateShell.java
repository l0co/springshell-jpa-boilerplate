package com.lifeinide.boilerplate.springshell.shell;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author Lukasz Frankowski
 */
@ShellComponent
public class CurrencyRateShell {

	@ShellMethod("Lists all currencies or displays a single currency.")
	public String currencyList(
		@ShellOption(arity = 1, help = "Currency to display.", defaultValue = ShellOption.NULL) Currency c
	) {
		return c!=null ? c.toString() : "null";
	}

}
