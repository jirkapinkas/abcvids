package cz.jiripinkas.abcvids.mvp;

import com.vaadin.navigator.View;

public class AbstractMVPPresenter implements MVPPresenter {
	
	private View view;

	@Override
	public View getView() {
		return view;
	}

	@Override
	public void setView(View view) {
		this.view = view;
	}

}
