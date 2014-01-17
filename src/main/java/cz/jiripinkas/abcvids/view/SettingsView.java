package cz.jiripinkas.abcvids.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.components.FormComponent;
import cz.jiripinkas.abcvids.components.MyCustomMenuBarView;
import cz.jiripinkas.abcvids.components.SettingsForm;
import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.ui.MyVaadinUI;

@UIComponent
@SuppressWarnings("serial")
public class SettingsView extends MyCustomMenuBarView {

	@Autowired
	private SettingsService settingsService;

	private FormComponent formComponent;
	private SettingsForm settingsForm;
	private Button buttonSave;
	private Button buttonCancel;
	private List<SettingsForm> settingsForms = new ArrayList<SettingsForm>();

	@Override
	public void enter(ViewChangeEvent event) {

	}

	@PostConstruct
	public void init() {
		List<Settings> list = settingsService.findAll();
		for (Settings settings : list) {
			SettingsForm settingsForm = new SettingsForm();
			settingsForm.setSettings(settings);
			formComponent.addComponents(settingsForm);
			settingsForms.add(settingsForm);
		}
	}

	@Override
	protected Layout buildLayout() {
		formComponent = new FormComponent(500);
		formComponent.setLabelValue("Settings:");

		settingsForm = new SettingsForm("New settings key:", "New settings value:");
		formComponent.addComponents(settingsForm);

		buttonSave = formComponent.getSaveButton();
		buttonCancel = formComponent.getCancelButton();

		return new VerticalLayout(formComponent);
	}

	@Override
	protected void setListeners() {

		buttonSave.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (!settingsForm.getKey().isEmpty() && !settingsForm.getValue().isEmpty()) {
					Settings settings = settingsForm.getSettings();
					settings.setId(null);
					settingsService.save(settings);

					SettingsForm settingsForm2 = new SettingsForm();
					settingsForm2.setSettings(settingsForm.getSettings());

					settingsForm.clearForm();

					formComponent.addComponents(settingsForm2);
					settingsForms.add(settingsForm2);
				}
				Iterator<SettingsForm> iterator = settingsForms.iterator();
				while (iterator.hasNext()) {
					SettingsForm settingsForm = iterator.next();
					if (settingsForm.getKey().isEmpty() && settingsForm.getValue().isEmpty()) {
						// delete all settings with empty key and value
						settingsService.delete(settingsForm.getSettings());
						iterator.remove();
						formComponent.getCentral().removeComponent(settingsForm);
					} else {
						// update all changed settings
						settingsService.save(settingsForm.getSettings());
					}
				}
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_SETTINGS);
			}
		});

		buttonCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyVaadinUI.VIEW_GROUPS);
			}
		});
	}

}
