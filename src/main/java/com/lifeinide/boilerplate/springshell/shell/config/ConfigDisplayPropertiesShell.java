package com.lifeinide.boilerplate.springshell.shell.config;

import com.lifeinide.boilerplate.springshell.display.ConfigurablePropertyRenderer;
import com.lifeinide.boilerplate.springshell.display.ConfigurablePropertyRenderer.PropertyDisplayMode;
import com.lifeinide.boilerplate.springshell.display.TablePropertyRenderer;
import com.lifeinide.boilerplate.springshell.shell.ShellGroups;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;

/**
 * @author Lukasz Frankowski
 */
@ShellComponent
@ShellCommandGroup(ShellGroups.CONFIG)
@RequiredArgsConstructor
public class ConfigDisplayPropertiesShell {

	private final ConfigurablePropertyRenderer configurablePropertyRenderer;
	private final TablePropertyRenderer tablePropertyRenderer;

	@ShellMethod("Lists possible display modes.")
	public String configDisplayModeList() {
		return Arrays.toString(PropertyDisplayMode.values());
	}

	@ShellMethod("Reads or sets display mode.")
	public String configDisplayMode(
		@ShellOption(arity = 1, help = "Display mode to set.", defaultValue = ShellOption.NULL) PropertyDisplayMode m
	) {
		if (m != null)
			configurablePropertyRenderer.setMode(m);
		return configurablePropertyRenderer.getMode().toString();
	}

	@ShellMethod("Reads or sets display size for tables.")
	public String configDisplaySize(
		@ShellOption(arity = 1, help = "Display size to set.", defaultValue = ShellOption.NULL) Integer s
	) {
		if (s != null)
			tablePropertyRenderer.setTableSize(s);
		return tablePropertyRenderer.getTableSize() + "";
	}

}
