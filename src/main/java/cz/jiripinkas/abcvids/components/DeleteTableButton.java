package cz.jiripinkas.abcvids.components;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public abstract class DeleteTableButton implements ColumnGenerator {

	@Override
	public Object generateCell(final Table source, final Object itemId, final Object columnId) {

		Button button = new Button("Delete");
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				ConfirmDialog.show(UI.getCurrent(), "Are you really sure?", new ConfirmDialog.Listener() {

					@Override
					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							try {
								delete(Integer.parseInt(itemId.toString()));
								source.getContainerDataSource().removeItem(itemId);
							} catch (Exception e) {
								Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
							}
						}
					}
				});

			}
		});
		return button;
	}

	public abstract void delete(int id);

}
