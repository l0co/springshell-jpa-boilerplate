package com.lifeinide.boilerplate.springshell.display;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Lukasz Frankowski
 */
@Component
@Primary
@RequiredArgsConstructor
public class ConfigurablePropertyRenderer implements IPropertyRenderer {

	private final PlainPropertyRenderer plainPropertyRenderer;
	private final TablePropertyRenderer tablePropertyRenderer;

	@Getter @Setter
	private PropertyDisplayMode mode = PropertyDisplayMode.TABLE;

	@Override
	public String render(Iterable<? extends IDisplayProperties> collection) {
		return pickRenderer().render(collection);
	}

	@Override
	public String render(IDisplayProperties object) {
		return pickRenderer().render(object);
	}

	protected IPropertyRenderer pickRenderer() {
		return PropertyDisplayMode.TABLE.equals(mode) ? tablePropertyRenderer : plainPropertyRenderer;
	}

	public enum PropertyDisplayMode {
		PLAIN,
		TABLE
	}

}
