package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.DeleteTableButton;
import cz.jiripinkas.abcvids.components.MyCustomMenuBarView;
import cz.jiripinkas.abcvids.components.NavigatorTableButton;
import cz.jiripinkas.abcvids.dto.GroupOverviewDto;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.service.InitDbSettingsService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class GroupListView extends MyCustomMenuBarView {

	private Table table;

	private Button addButton;

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private SettingsService settingsService;

	@Override
	public void enter(ViewChangeEvent event) {
		BeanContainer<Integer, GroupOverviewDto> container = new BeanContainer<Integer, GroupOverviewDto>(GroupOverviewDto.class);
		container.setBeanIdProperty("id");
		container.addAll(groupService.findAllOverview());

		table.setContainerDataSource(container);

		table.removeGeneratedColumn("open");
		table.addGeneratedColumn("open", new NavigatorTableButton("Open") {

			@Override
			public void navigateToUrl(String id) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + id);
			}
		});

		table.removeGeneratedColumn("edit");
		table.addGeneratedColumn("edit", new NavigatorTableButton("Edit") {

			@Override
			public void navigateToUrl(String id) {
				UI.getCurrent().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUP_DETAIL + "/" + id);
			}
		});

		table.removeGeneratedColumn("delete");
		table.addGeneratedColumn("delete", new DeleteTableButton() {

			@Override
			public void delete(int id) {
				groupService.delete(id);
			}
		});

		table.removeGeneratedColumn("public");
		table.addGeneratedColumn("public", new NavigatorTableButton(">") {

			@Override
			public void navigateToUrl(String id) {
				Group group = groupService.findOne(Integer.parseInt(id));
				UI.getCurrent().getPage().open("/" + settingsService.findOne(InitDbSettingsService.SETTINGS_GROUP_URL_PART).getValue() + "/" + group.getShortName() + ".html", "_blank");
			}
		});

	}

	@Override
	protected Layout buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		addButton = new Button("Add group");
		layout.addComponent(addButton);
		Label groupListLabel = new Label("Groups:");
		layout.addComponent(groupListLabel);

		table = new Table();

		table.setSelectable(true);
		table.setImmediate(true);

		layout.addComponent(table);

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

		table.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.isDoubleClick()) {
					getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEMS + "/" + event.getItemId());
				}
			}
		});
	}

}
