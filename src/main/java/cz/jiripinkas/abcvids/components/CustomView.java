package cz.jiripinkas.abcvids.components;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public abstract class CustomView extends CustomComponent implements View {

	protected VerticalLayout mainLayout;

	public CustomView() {
		mainLayout = new VerticalLayout();
		setCompositionRoot(mainLayout);
	}

}