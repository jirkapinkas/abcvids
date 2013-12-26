package cz.jiripinkas.abcvids.components;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class SaveButton extends Button {

	public SaveButton() {
		setClickShortcut(KeyCode.ENTER);
		addStyleName(Reindeer.BUTTON_DEFAULT);
		setCaption("Save");
	}
}
