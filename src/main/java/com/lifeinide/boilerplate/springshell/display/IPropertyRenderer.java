package com.lifeinide.boilerplate.springshell.display;

/**
 * @author Lukasz Frankowski
 */
public interface IPropertyRenderer {

	String render(Iterable<? extends IDisplayProperties> collection);
	String render(IDisplayProperties object);

}
