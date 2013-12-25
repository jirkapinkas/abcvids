package cz.jiripinkas.abcvids.view;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.presenter.GroupDetailPresenter;

@SuppressWarnings("serial")
@UIComponent
public class GroupDetailViewImpl extends AbstractMVPView implements
		GroupDetailView {

	private TextField textFieldKeywords;
	private TextField textFieldName;
	private TextField textFieldDescription;
	private TextField textFieldSeoDescription;

	@Override
	public void enter(ViewChangeEvent event) {
		final GroupDetailPresenter presenter = (GroupDetailPresenter) getPresenter();

		// create layout
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		Label labelTitle = new Label("New group:");
		layout.addComponent(labelTitle);

		Label labelName = new Label("Name:");
		layout.addComponent(labelName);

		textFieldName = new TextField();
		layout.addComponent(textFieldName);

		Label labelKeywords = new Label("Keywords:");
		layout.addComponent(labelKeywords);

		textFieldKeywords = new TextField();
		layout.addComponent(textFieldKeywords);

		Label labelDescription = new Label("Description:");
		layout.addComponent(labelDescription);

		textFieldDescription = new TextField();
		layout.addComponent(textFieldDescription);

		Label labelSeoDescription = new Label("SEO Description:");
		layout.addComponent(labelSeoDescription);

		textFieldSeoDescription = new TextField();
		layout.addComponent(textFieldSeoDescription);
		
		Button button = new Button("Save");
		button.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				presenter.save();
			}
		});
		layout.addComponent(button);

		setCompositionRoot(layout);
	}

	@Override
	public String getKeywords() {
		return textFieldKeywords.getValue();
	}

	@Override
	public String getName() {
		return textFieldName.getValue();
	}

	@Override
	public String getSeoDescription() {
		return textFieldSeoDescription.getValue();
	}

	@Override
	public String getItemDescription() {
		return textFieldDescription.getValue();
	}

}
