package com.lifeinide.boilerplate.springshell.display;

import org.springframework.lang.NonNull;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukasz Frankowski
 */
@Component
public class TablePropertyRenderer extends PlainPropertyRenderer {

	@Override
	protected void doRender(@NonNull StringBuilder sb, @NonNull Iterable<? extends IDisplayProperties> collection) {
		List<IDisplayProperties> actualList = new ArrayList<>();
		collection.iterator().forEachRemaining(actualList::add);
		IDisplayProperties prototype = actualList.get(0);

		Object[][] arr = new Object[actualList.size()+1][prototype.displayProperties().size()];

		arr[0] = prototype.displayProperties().stream()
			.map(DisplayProperty::getName)
			.toArray(String[]::new);

		for (int i=0; i<actualList.size(); i++) {
			IDisplayProperties object = actualList.get(i);
			arr[i+1] = object.displayProperties().stream()
				.map(DisplayProperty::getValue)
				.toArray(Object[]::new);
		}

		TableModel tableModel = new ArrayTableModel(arr);
		TableBuilder tableBuilder = new TableBuilder(tableModel);
		tableBuilder.addFullBorder(BorderStyle.oldschool);
		sb.append(tableBuilder.build().render(100)); // TODOLF externalize as prop
	}

}
