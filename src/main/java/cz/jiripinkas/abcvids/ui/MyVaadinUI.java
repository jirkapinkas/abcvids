package cz.jiripinkas.abcvids.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.mvp.impl.MVPGroupDetail;
import cz.jiripinkas.abcvids.mvp.impl.MVPGroups;

@Theme("mytheme")
@SuppressWarnings("serial")
@UIComponent
public class MyVaadinUI extends UI {
	
	@Autowired
	private MVPGroups mvpGroups;
	
	@Autowired
	private MVPGroupDetail mvpGroupDetail;

	public static final String VIEW_GROUPS = "";
	
	public static final String VIEW_GROUP_DETAIL = "group";

	private Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		navigator = new Navigator(this, this);
		navigator.addView(VIEW_GROUPS, mvpGroups.getView());
		navigator.addView(VIEW_GROUP_DETAIL, mvpGroupDetail.getView());
	}

}
