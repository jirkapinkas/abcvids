package cz.jiripinkas.abcvids.mvp;

import com.vaadin.navigator.View;

public interface MVPView extends View {

	void setPresenter(MVPPresenter presenter);

	MVPPresenter getPresenter();

}
