package com.lifeinide.boilerplate.springshell.display;

import org.springframework.lang.NonNull;

/**
 * @author Lukasz Frankowski
 */
public abstract class AbstractPropertyRenderer implements IPropertyRenderer {

	@Override
	public final String render(Iterable<? extends IDisplayProperties> collection) {
		if (collection == null || !collection.iterator().hasNext())
			return "(empty)";
		StringBuilder sb = new StringBuilder();
		doRender(sb, collection);
		return sb.toString();
	}

	protected abstract void doRender(@NonNull StringBuilder sb, @NonNull Iterable<? extends IDisplayProperties> collection);

	@Override
	public String render(IDisplayProperties object) {
		if (object == null)
			return "(empty)";
		StringBuilder sb = new StringBuilder();
		doRender(sb, object);
		return sb.toString();
	}

	protected abstract void doRender(@NonNull StringBuilder sb, @NonNull IDisplayProperties object);

}
