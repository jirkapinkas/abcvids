package cz.jiripinkas.abcvids.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomView;
import cz.jiripinkas.abcvids.form.UserForm;

@UIComponent
@SuppressWarnings("serial")
public class UserDetailView extends CustomView {

	@Autowired
	private UserForm form;

	@Override
	public void enter(ViewChangeEvent event) {
		form.init();
	}

	@PostConstruct
	public void init() {
		form.setLabelValue("Change password");
		mainLayout.addComponent(form);
	}

}
