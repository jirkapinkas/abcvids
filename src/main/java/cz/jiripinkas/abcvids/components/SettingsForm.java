package cz.jiripinkas.abcvids.components;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import cz.jiripinkas.abcvids.entity.Settings;

@SuppressWarnings("serial")
public class SettingsForm extends CustomComponent {

	private TextField settingsKey;
	private TextArea settingsValue;
	private Settings settings = new Settings();
	private Layout layout;

	public SettingsForm() {
		this("key:", "value:");
	}

	public SettingsForm(String keyCaption, String valueCaption) {
		settingsKey = new TextField(keyCaption);
		settingsKey.setWidth("500px");
		settingsValue = new TextArea(valueCaption);
		settingsValue.setWidth("500px");
		layout = new FormLayout(settingsKey, settingsValue);
//		layout.addStyleName("bordered");
		setCompositionRoot(layout);
	}

	public String getKey() {
		return settingsKey.getValue();
	}

	public String getValue() {
		return settingsValue.getValue();
	}

	public Settings getSettings() {
		settings.setKey(getKey());
		settings.setValue(getValue());
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
		settingsKey.setValue(settings.getKey());
		settingsValue.setValue(settings.getValue());
	}

	public void clearForm() {
		settingsKey.setValue("");
		settingsValue.setValue("");
	}

}
