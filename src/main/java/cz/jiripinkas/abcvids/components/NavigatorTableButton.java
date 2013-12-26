package cz.jiripinkas.abcvids.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

@SuppressWarnings("serial")
public abstract class NavigatorTableButton implements ColumnGenerator {

	private String caption;

	public NavigatorTableButton(String caption) {
		this.caption = caption;
	}

	@Override
	public Object generateCell(final Table source, final Object itemId, final Object columnId) {
		Button button = new Button(caption);
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				navigateToUrl(itemId.toString());
			}
		});
		return button;
	}

	public abstract void navigateToUrl(String id);

}
