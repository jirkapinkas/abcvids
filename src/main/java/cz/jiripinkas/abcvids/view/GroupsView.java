package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class GroupsView extends CustomComponent implements View {

	private Table groupsTable;

	private Button addButton;

	private Label groupListLabel;
	
	@Autowired 
	private GroupService groupService;

	@Override
	public void enter(ViewChangeEvent event) {

		// load data
		BeanContainer<Integer, Group> container = new BeanContainer<Integer, Group>(
				Group.class);
		container.setBeanIdProperty("id");
		container.addAll(groupService.findAll());

		// create layout
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		addButton = new Button("Add group");
		layout.addComponent(addButton);
		
		addButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUP_DETAIL);
			}
		});

		groupListLabel = new Label("Groups:");
		layout.addComponent(groupListLabel);

		groupsTable = new Table();
		groupsTable.setSelectable(true);
		groupsTable.setImmediate(true);
		groupsTable.setContainerDataSource(container);
		groupsTable.setVisibleColumns("name", "description");
		layout.addComponent(groupsTable);
		setCompositionRoot(layout);
	}

}
