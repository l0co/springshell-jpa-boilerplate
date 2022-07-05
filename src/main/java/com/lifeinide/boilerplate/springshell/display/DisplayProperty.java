package com.lifeinide.boilerplate.springshell.display;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

/**
 * @author Lukasz Frankowski
 */
@RequiredArgsConstructor
@Value
public class DisplayProperty {

	String name;
	Object value;

	public static DisplayProperty of(@NonNull String name, @NonNull Object value) {
		return new DisplayProperty(name, value);
	}

}
