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
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class GroupDetailView extends MyCustomMenuBarView {

	private Button buttonSave;
	private Button buttonCancel;
	private TextField keywords;
	private TextField name;
	private TextField shortName;
	private TextArea description;
	private TextArea seoDescription;

	private FieldGroup fieldGroup;

	@Autowired
	private GroupService groupService;

	@Override
	public void enter(ViewChangeEvent event) {
		name.focus();
		fieldGroup = new BeanFieldGroup<Group>(Group.class);
		Group group = null;
		if(event.getParameters().equals("")) {
			System.out.println("disable short name");
			group = new Group();
			shortName.setVisible(false);
		} else {
			group = groupService.findOne(Integer.parseInt(event.getParameters()));
			shortName.setVisible(true);
		}
		fieldGroup.setItemDataSource(new BeanItem<Group>(group));
		fieldGroup.bindMemberFields(this);
	}

	@Override
	protected Layout buildLayout() {
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		
		Label labelTitle = new Label("New group:");
		name = new TextField("Name:");
		shortName = new TextField("Short name:");
		keywords = new TextField("Keywords:");
		description = new TextArea("Description:");
		seoDescription = new TextArea("SEO Description:");

		layout.addComponents(labelTitle, name, shortName, keywords, description, seoDescription);

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
					BeanItem<Group> beanItem = (BeanItem<Group>) fieldGroup.getItemDataSource();
					Group group = beanItem.getBean();

					groupService.save(group);
					Notification.show("saved");
					getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
				} catch (CommitException e) {
					Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		});

		buttonCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
			}
		});
	}

}
