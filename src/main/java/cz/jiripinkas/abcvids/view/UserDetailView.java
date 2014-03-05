package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.PasswordField;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomView;
import cz.jiripinkas.abcvids.components.FormComponent;
import cz.jiripinkas.abcvids.entity.User;
import cz.jiripinkas.abcvids.service.UserService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;
import cz.jiripinkas.abcvids.util.SpringSecurityHelper;

@UIComponent
@SuppressWarnings("serial")
public class UserDetailView extends CustomView {

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

	public UserDetailView() {
		formComponent = new FormComponent(500);

		password = new PasswordField("New password:");
		formComponent.addComponents(password);

		buttonSave = formComponent.getSaveButton();
		buttonCancel = formComponent.getCancelButton();

		formComponent.setLabelValue("Change password");

		mainLayout.addComponent(formComponent);

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
