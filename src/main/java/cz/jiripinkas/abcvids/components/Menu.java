package cz.jiripinkas.abcvids.components;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
public class Menu extends MenuBar {

	public Menu() {
		setWidth("100%");

		MenuItem mainItem = addItem("Main", null);
		mainItem.addItem("All groups", new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
			}
		});

		mainItem.addItem("Settings", new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.VIEW_SETTINGS);
			}
		});
		mainItem.addItem("Change password", new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.VIEW_USER_DETAIL);
			}
		});

		mainItem.addItem("Logout", new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getPage().open("/logout", null);
			}
		});
	}
}
