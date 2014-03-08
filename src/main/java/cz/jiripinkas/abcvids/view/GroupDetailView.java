package cz.jiripinkas.abcvids.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomView;
import cz.jiripinkas.abcvids.form.GroupForm;

@SuppressWarnings("serial")
@UIComponent
public class GroupDetailView extends CustomView {

	@Autowired
	private GroupForm form;

	@Override
	public void enter(ViewChangeEvent event) {
		form.init(event.getParameters());
	}

	public GroupDetailView() {
	}

	@PostConstruct
	public void init() {
		mainLayout.addComponent(form);
	}

}
