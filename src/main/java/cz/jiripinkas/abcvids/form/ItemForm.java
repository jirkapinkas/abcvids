package cz.jiripinkas.abcvids.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomForm;
import cz.jiripinkas.abcvids.components.MyRichTextEditor;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@UIComponent
@SuppressWarnings("serial")
public class ItemForm extends CustomForm<Item> {

	private TextField name;
	private TextField shortName;
	private TextField keywords;
	private MyRichTextEditor description;
	private TextArea seoDescription;
	private TextField url;
	private TextField image;
	private int groupId;

	@Autowired
	private ItemService itemService;

	@Autowired
	private SettingsService settingsService;

	public ItemForm() {
		name = new TextField("Name:");
		shortName = new TextField("Short name:");
		keywords = new TextField("Keywords:");
		description = new MyRichTextEditor("Description:");
		seoDescription = new TextArea("SEO Description:");
		image = new TextField("Image (from images folder):");
		url = new TextField("URL:");

		addComponents(name, shortName, keywords, description, seoDescription, url, image);
	}
	
	public void init(String params) {
		name.focus();
		String[] parameters = params.split("/");
		groupId = Integer.parseInt(parameters[0]);
		Item item = null;
		if (parameters.length == 1) {
			item = new Item();
			shortName.setVisible(false);
			item.setImage(settingsService.findOne("ImageItemLogo").getValue());
			setLabelValue("New item:");
		} else {
			int itemId = Integer.parseInt(parameters[1]);
			item = itemService.findOne(itemId);
			shortName.setVisible(true);
			setLabelValue("Edit item:");
		}
		super.setComponent(item, Item.class);
	}

	@Override
	public void onSave() {
		try {
			Item item = super.getComponent();
			itemService.save(item, groupId);
			Notification.show("saved");
			getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + groupId);
		} catch (CommitException e) {
			Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	@Override
	public void onCancel() {
		getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + groupId);
	}

}
