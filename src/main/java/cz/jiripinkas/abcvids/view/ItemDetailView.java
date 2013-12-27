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
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CancelButton;
import cz.jiripinkas.abcvids.components.MyCustomMenuBarView;
import cz.jiripinkas.abcvids.components.SaveButton;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class ItemDetailView extends MyCustomMenuBarView {

	private Button buttonSave;
	private Button buttonCancel;

	private TextField name;
	private TextField shortName;
	private TextField keywords;
	private TextArea description;
	private TextArea seoDescription;
	private TextField url;

	private FieldGroup fieldGroup;

	private int groupId;

	@Autowired
	private ItemService itemService;

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
		} else {
			int itemId = Integer.parseInt(parameters[1]);
			item = itemService.findOne(itemId);
			shortName.setVisible(true);
		}
		fieldGroup.setItemDataSource(new BeanItem<Item>(item));
		fieldGroup.bindMemberFields(this);
	}

	@Override
	protected Layout buildLayout() {
		FormLayout layout = new FormLayout();
		layout.setMargin(true);

		Label labelTitle = new Label("New item:");
		name = new TextField("Name:");
		shortName = new TextField("Short name:");
		keywords = new TextField("Keywords:");
		description = new TextArea("Description:");
		seoDescription = new TextArea("SEO Description:");
		url = new TextField("URL:");

		layout.addComponents(labelTitle, name, shortName, keywords, description, seoDescription, url);

		buttonSave = new SaveButton();
		layout.addComponent(buttonSave);

		buttonCancel = new CancelButton();
		layout.addComponent(buttonCancel);

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
