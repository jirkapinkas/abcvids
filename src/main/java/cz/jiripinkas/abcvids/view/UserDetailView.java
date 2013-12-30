package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.FormComponent;
import cz.jiripinkas.abcvids.components.MyCustomMenuBarView;
import cz.jiripinkas.abcvids.entity.User;
import cz.jiripinkas.abcvids.service.UserService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;
import cz.jiripinkas.abcvids.util.SpringSecurityHelper;

@UIComponent
@SuppressWarnings("serial")
public class UserDetailView extends MyCustomMenuBarView {

	private PasswordField password;

	private FormComponent formComponent;

	private Button buttonSave;
	private Button buttonCancel;

	private User user;

	@Autowired
	private UserService userService;

	@Override
	public void enter(ViewChangeEvent event) {
		user = userService.findOne(SpringSecurityHelper.getPrincipalName());
		password.setValue("");
	}

	@Override
	protected Layout buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		formComponent = new FormComponent(500);

		password = new PasswordField("New password:");
		formComponent.addComponents(password);

		buttonSave = formComponent.getSaveButton();
		buttonCancel = formComponent.getCancelButton();

		formComponent.setLabelValue("Change password");

		layout.addComponent(formComponent);
		return layout;
	}

	@Override
	protected void setListeners() {

		buttonSave.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				userService.changePassword(user, password.getValue());
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
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
