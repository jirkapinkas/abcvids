package cz.jiripinkas.abcvids.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class FormComponent extends CustomComponent {
	private VerticalLayout mainLayout;

	protected HorizontalLayout header;
	protected FormLayout central;
	protected HorizontalLayout footer;
	protected Label label;
	protected SaveButton saveButton;
	protected CancelButton cancelButton;
	protected int pixelsWidth;

	public FormComponent(int pixelsWidth) {
		this.pixelsWidth = pixelsWidth;
		header = new HorizontalLayout();
		central = new FormLayout();
		footer = new HorizontalLayout();

		mainLayout = new VerticalLayout();
		mainLayout.setMargin(true);
		mainLayout.addComponent(header);
		mainLayout.addComponent(central);
		mainLayout.addComponent(footer);

		setCompositionRoot(mainLayout);
		setSizeUndefined();

		// label = new Label("<h1>" + labelString + "</h1>", ContentMode.HTML);
		label = new Label();
		label.addStyleName("myheader");
		header.addComponent(label);

		saveButton = new SaveButton();
		cancelButton = new CancelButton();

		footer.addComponent(saveButton);
		footer.addComponent(cancelButton);
		footer.setSpacing(true);
	}
	
	public void addComponents(Component ... components) {
		for (Component component : components) {
			component.setWidth(pixelsWidth + "px");
		}
		getCentral().addComponents(components);
	}

	public Layout getCentral() {
		return central;
	}

	public Layout getMainLayout() {
		return mainLayout;
	}

	public SaveButton getSaveButton() {
		return saveButton;
	}

	public CancelButton getCancelButton() {
		return cancelButton;
	}
	
	public void setLabelValue(String value) {
		label.setValue(value);
	}
}