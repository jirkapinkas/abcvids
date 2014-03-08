package cz.jiripinkas.abcvids.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.PasswordField;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomForm;
import cz.jiripinkas.abcvids.entity.User;
import cz.jiripinkas.abcvids.service.UserService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;
import cz.jiripinkas.abcvids.util.SpringSecurityHelper;

@UIComponent
@SuppressWarnings("serial")
public class UserForm extends CustomForm<User> {

	public UserForm() {
		password = new PasswordField("New password:");
		addComponents(password);
	}

	private PasswordField password;

	@Autowired
	private UserService userService;

	private User user;

	public void init() {
		user = userService.findOne(SpringSecurityHelper.getPrincipalName());
		password.setValue("");
	}

	@Override
	public void onSave() {
		userService.changePassword(user, password.getValue());
		getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
	}

	@Override
	public void onCancel() {
		getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
	}

}
