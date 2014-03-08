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
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@UIComponent
@SuppressWarnings("serial")
public class GroupForm extends CustomForm<Group> {

	private TextField keywords;
	private TextField name;
	private TextField shortName;
	private TextField image;
	private MyRichTextEditor description;
	private TextArea seoDescription;

	@Autowired
	private GroupService groupService;

	@Autowired
	private SettingsService settingsService;

	public GroupForm() {
		name = new TextField("Name:");
		shortName = new TextField("Short name:");
		keywords = new TextField("Keywords:");
		description = new MyRichTextEditor("Description:");
		seoDescription = new TextArea("SEO Description:");
		image = new TextField("Image (from images folder):");

		addComponents(name, shortName, keywords, description, seoDescription, image);
	}

	public void init(String params) {
		name.focus();
		Group group = null;
		if (params.equals("")) {
			group = new Group();
			shortName.setVisible(false);
			group.setImage(settingsService.findOne("ImageGroupLogo").getValue());
			setLabelValue("New group:");
		} else {
			group = groupService.findOne(Integer.parseInt(params));
			shortName.setVisible(true);
			setLabelValue("Edit group:");
		}
		super.setComponent(group, Group.class);
	}

	@Override
	public void onSave() {
		try {
			Group group = super.getComponent();
			groupService.save(group);
			Notification.show("saved");
			getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
		} catch (CommitException e) {
			Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	@Override
	public void onCancel() {
		getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
	}

}
