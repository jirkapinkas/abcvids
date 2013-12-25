package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.dto.GroupOverviewDto;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class GroupListView extends MyCustomMenuBarView {

	private Table groupsTable;

	private Button addButton;

	private Label groupListLabel;

	@Autowired
	private GroupService groupService;

	@Override
	public void enter(ViewChangeEvent event) {
		BeanContainer<Integer, GroupOverviewDto> container = new BeanContainer<Integer, GroupOverviewDto>(GroupOverviewDto.class);
		container.setBeanIdProperty("id");
		container.addAll(groupService.findAll());

		groupsTable.setContainerDataSource(container);
		groupsTable.setVisibleColumns("name", "description");

		groupsTable.removeGeneratedColumn("delete");
		groupsTable.addGeneratedColumn("delete", new ColumnGenerator() {

			@Override
			public Object generateCell(final Table source, final Object itemId, Object columnId) {
				Button button = new Button("Delete");
				button.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						try {
							groupService.delete(Integer.parseInt(itemId.toString()));
							source.getContainerDataSource().removeItem(itemId);
						} catch (Exception e) {
							Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
						}
					}
				});
				return button;
			}
		});
	}

	@Override
	protected Layout buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		addButton = new Button("Add group");
		layout.addComponent(addButton);
		groupListLabel = new Label("Groups:");
		layout.addComponent(groupListLabel);

		groupsTable = new Table();

		groupsTable.setSelectable(true);
		groupsTable.setImmediate(true);

		layout.addComponent(groupsTable);

		return layout;
	}

	@Override
	protected void setListeners() {
		addButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUP_DETAIL);
			}
		});
	}

}
