package cz.jiripinkas.abcvids.components;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
public abstract class MyCustomMenuBarView extends CustomComponent implements View {

	protected VerticalLayout mainLayout;

	public MyCustomMenuBarView() {
		mainLayout = new VerticalLayout();
		mainLayout.addComponent(constructMenuBar());
		setCompositionRoot(mainLayout);

		// add rest of the page. Do not remove!!!
		mainLayout.addComponent(buildLayout());
		setListeners();
	}

	private MenuBar constructMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setWidth("100%");

		MenuItem mainItem = menuBar.addItem("Main", null);
		mainItem.addItem("All groups", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
			}
		});

		mainItem.addItem("Settings", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_SETTINGS);
			}
		});
		mainItem.addItem("Change password", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_USER_DETAIL);
			}
		});

		mainItem.addItem("Logout", new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getPage().open("/logout", null);
			}
		});

		return menuBar;
	}

	protected abstract Layout buildLayout();

	protected abstract void setListeners();

}