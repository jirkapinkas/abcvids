package cz.jiripinkas.abcvids.view;

import com.vaadin.ui.CustomComponent;

import cz.jiripinkas.abcvids.mvp.MVPPresenter;
import cz.jiripinkas.abcvids.mvp.MVPView;

@SuppressWarnings("serial")
public abstract class AbstractMVPView extends CustomComponent implements MVPView {

	private MVPPresenter presenter;

	@Override
	public void setPresenter(MVPPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public MVPPresenter getPresenter() {
		return presenter;
	}

}
