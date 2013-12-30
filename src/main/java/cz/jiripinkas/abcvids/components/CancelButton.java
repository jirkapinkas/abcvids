package cz.jiripinkas.abcvids.components;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.NativeButton;

@SuppressWarnings("serial")
public class CancelButton extends NativeButton {

	public CancelButton() {
		setClickShortcut(KeyCode.ESCAPE);
		setCaption("Cancel");
		setStyleName("btn-grey");
	}
}
