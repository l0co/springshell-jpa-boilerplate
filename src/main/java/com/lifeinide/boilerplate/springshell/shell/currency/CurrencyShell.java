package com.lifeinide.boilerplate.springshell.shell.currency;

import com.lifeinide.boilerplate.springshell.enums.Currency;
import com.lifeinide.boilerplate.springshell.shell.ShellGroups;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;

/**
 * @author Lukasz Frankowski
 */
@ShellComponent
@ShellCommandGroup(ShellGroups.CURRENCY)
public class CurrencyShell {

	@ShellMethod("Lists all currencies.")
	public String currencyList() {
		return Arrays.toString(Currency.values());
	}

}
