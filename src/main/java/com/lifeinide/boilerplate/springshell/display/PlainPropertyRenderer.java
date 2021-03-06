package com.lifeinide.boilerplate.springshell.display;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author Lukasz Frankowski
 */
@Component
public class PlainPropertyRenderer extends AbstractPropertyRenderer {

	@Override
	protected void doRender(@NonNull StringBuilder sb, @NonNull Iterable<? extends IDisplayProperties> collection) {
		for (Iterator<? extends IDisplayProperties> iterator = collection.iterator(); iterator.hasNext();) {
			doRender(sb, iterator.next());
			if (iterator.hasNext())
				sb.append("\n\n");
		}
	}

	@Override
	protected void doRender(@NonNull StringBuilder sb, @NonNull IDisplayProperties object) {
		if (object.displayProperties().isEmpty()) {
			sb.append("(no properties)");
			return;
		}

		for (Iterator<DisplayProperty> iterator = object.displayProperties().iterator(); iterator.hasNext(); ) {
			DisplayProperty prop = iterator.next();
			sb.append(String.format("%s=%s", prop.getName(), prop.getValue()));
			if (iterator.hasNext())
				sb.append("\n");
		}
	}

}
