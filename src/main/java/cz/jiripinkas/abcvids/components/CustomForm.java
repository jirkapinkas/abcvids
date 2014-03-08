package cz.jiripinkas.abcvids.components;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings({ "serial", "unchecked" })
public abstract class CustomForm<T> extends CustomComponent {
	private VerticalLayout mainLayout;

	protected HorizontalLayout header;
	protected FormLayout central;
	protected HorizontalLayout footer;
	protected Label label;
	protected SaveButton saveButton;
	protected CancelButton cancelButton;
	protected int pixelsWidth;

	protected FieldGroup fieldGroup;

	private static final int DEFAULT_PIXELS_WIDTH = 500;

	public CustomForm() {
		this(DEFAULT_PIXELS_WIDTH);
	}

	public CustomForm(int pixelsWidth) {
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

		saveButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				onSave();
			}
		});

		cancelButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				onCancel();
			}
		});
	}

	public void addComponents(Component... components) {
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

	public void setLabelValue(String value) {
		label.setValue(value);
	}

	public abstract void onSave();

	public abstract void onCancel();

	public void setComponent(T component, Class<T> type) {
		fieldGroup = new BeanFieldGroup<T>(type);
		fieldGroup.setItemDataSource(new BeanItem<T>(component));
		fieldGroup.bindMemberFields(this);
	}

	public T getComponent() throws CommitException {
		fieldGroup.commit();
		BeanItem<T> beanItem = (BeanItem<T>) fieldGroup.getItemDataSource();
		return beanItem.getBean();
	}
}