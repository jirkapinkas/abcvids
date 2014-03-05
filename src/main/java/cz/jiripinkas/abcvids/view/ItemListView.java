package cz.jiripinkas.abcvids.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.CustomView;
import cz.jiripinkas.abcvids.components.DeleteTableButton;
import cz.jiripinkas.abcvids.components.NavigatorTableButton;
import cz.jiripinkas.abcvids.dto.ItemOverviewDto;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.InitDbSettingsService;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@SuppressWarnings("serial")
@UIComponent
public class ItemListView extends CustomView {

	@Autowired
	private ItemService itemService;

	private Button addButton;

	private Table table;

	private int groupId;

	@Autowired
	private SettingsService settingsService;

	@Override
	public void enter(ViewChangeEvent event) {
		groupId = Integer.parseInt(event.getParameters());

		BeanContainer<Integer, ItemOverviewDto> container = new BeanContainer<Integer, ItemOverviewDto>(ItemOverviewDto.class);
		container.setBeanIdProperty("id");
		container.addAll(itemService.findAllOverview(groupId));

		table.setContainerDataSource(container);

		table.removeGeneratedColumn("edit");
		table.addGeneratedColumn("edit", new NavigatorTableButton("Edit") {

			@Override
			public void navigateToUrl(String id) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEM_DETAIL + "/" + groupId + "/" + id);
			}
		});

		table.removeGeneratedColumn("delete");
		table.addGeneratedColumn("delete", new DeleteTableButton() {

			@Override
			public void delete(int id) {
				itemService.delete(id);
			}
		});

		table.removeGeneratedColumn("public");
		table.addGeneratedColumn("public", new NavigatorTableButton(">") {

			@Override
			public void navigateToUrl(String id) {
				Item item = itemService.findOne(Integer.parseInt(id));
				UI.getCurrent().getPage().open("/" + settingsService.findOne(InitDbSettingsService.SETTINGS_ITEM_URL_PART).getValue() + "/" + item.getShortName() + ".html", "_blank");
			}
		});

	}

	public ItemListView() {
		addButton = new Button("Add item");
		Label groupListLabel = new Label("Items:");

		table = new Table();
		table.setSelectable(true);
		table.setImmediate(true);

		mainLayout.addComponents(addButton, groupListLabel, table);

		addButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_ITEM_DETAIL + "/" + groupId);
			}
		});
	}

}
