package cz.jiripinkas.abcvids.mvp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class MVP<T1 extends MVPPresenter, T2 extends MVPView> {

	@Autowired
	private T1 presenter;

	@Autowired
	private T2 view;
	
	@PostConstruct
	public void init() {
		presenter.setView(view);
		view.setPresenter(presenter);
	}

	public T1 getPresenter() {
		return presenter;
	}

	public T2 getView() {
		return view;
	}

}
