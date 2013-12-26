package cz.jiripinkas.abcvids.components;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;

@SuppressWarnings("serial")
public class CancelButton extends Button {

	public CancelButton() {
		setClickShortcut(KeyCode.ESCAPE);
		setCaption("Cancel");
	}
}
