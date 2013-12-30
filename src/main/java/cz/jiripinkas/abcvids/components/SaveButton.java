package cz.jiripinkas.abcvids.components;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class SaveButton extends NativeButton {

	public SaveButton() {
		setClickShortcut(KeyCode.ENTER);
		addStyleName(Reindeer.BUTTON_DEFAULT);
		setCaption("Save");
		setStyleName("btn-green");
	}
}
