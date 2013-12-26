package cz.jiripinkas.abcvids.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.view.GroupDetailView;
import cz.jiripinkas.abcvids.view.GroupListView;
import cz.jiripinkas.abcvids.view.ItemDetailView;
import cz.jiripinkas.abcvids.view.ItemListView;

@Theme("mytheme")
@SuppressWarnings("serial")
@UIComponent
public class MyVaadinUI extends UI {

	@Autowired
	private GroupListView groupsView;

	@Autowired
	private GroupDetailView groupDetailView;

	@Autowired
	private ItemListView itemsView;

	@Autowired
	private ItemDetailView itemDetailView;

	public static final String VIEW_GROUPS = "";

	public static final String VIEW_GROUP_DETAIL = "group-detail";

	public static final String VIEW_ITEMS = "items";

	public static final String VIEW_ITEM_DETAIL = "item-detail";

	private Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		navigator = new Navigator(this, this);
		navigator.addView(VIEW_GROUPS, groupsView);
		navigator.addView(VIEW_GROUP_DETAIL, groupDetailView);
		navigator.addView(VIEW_ITEMS, itemsView);
		navigator.addView(VIEW_ITEM_DETAIL, itemDetailView);
	}

}
