package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.FormComponent;
import cz.jiripinkas.abcvids.components.MyCustomMenuBarView;
import cz.jiripinkas.abcvids.components.MyRichTextEditor;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class ItemDetailView extends MyCustomMenuBarView {

	private Button buttonSave;
	private Button buttonCancel;

	private TextField name;
	private TextField shortName;
	private TextField keywords;
	private MyRichTextEditor description;
	private TextArea seoDescription;
	private TextField url;
	private TextField image;

	private FieldGroup fieldGroup;

	private int groupId;

	private FormComponent formComponent;

	@Autowired
	private ItemService itemService;

	@Autowired
	private SettingsService settingsService;

	@Override
	public void enter(ViewChangeEvent event) {
		name.focus();
		String[] parameters = event.getParameters().split("/");

		groupId = Integer.parseInt(parameters[0]);

		fieldGroup = new BeanFieldGroup<Item>(Item.class);
		Item item = null;
		if (parameters.length == 1) {
			item = new Item();
			shortName.setVisible(false);
			item.setImage(settingsService.findOne("ImageItemLogo").getValue());
			formComponent.setLabelValue("New item:");
		} else {
			int itemId = Integer.parseInt(parameters[1]);
			item = itemService.findOne(itemId);
			shortName.setVisible(true);
			formComponent.setLabelValue("Edit item:");
		}
		fieldGroup.setItemDataSource(new BeanItem<Item>(item));
		fieldGroup.bindMemberFields(this);
	}

	@Override
	protected Layout buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		formComponent = new FormComponent(500);

		name = new TextField("Name:");
		shortName = new TextField("Short name:");
		keywords = new TextField("Keywords:");
		description = new MyRichTextEditor("Description:");
		seoDescription = new TextArea("SEO Description:");
		image = new TextField("Image (from images folder):");
		url = new TextField("URL:");

		formComponent.addComponents(name, shortName, keywords, description, seoDescription, url, image);

		buttonSave = formComponent.getSaveButton();
		buttonCancel = formComponent.getCancelButton();

		layout.addComponent(formComponent);

		return layout;
	}

	@Override
	protected void setListeners() {

		buttonSave.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				try {
					fieldGroup.commit();
					@SuppressWarnings("unchecked")
					BeanItem<Item> beanItem = (BeanItem<Item>) fieldGroup.getItemDataSource();
					Item item = beanItem.getBean();

					itemService.save(item, groupId);
					Notification.show("saved");
					getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + groupId);
				} catch (CommitException e) {
					Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});

		buttonCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + groupId);
			}
		});
	}

}
