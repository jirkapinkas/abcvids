package cz.jiripinkas.abcvids.presenter;

import org.springframework.beans.factory.annotation.Autowired;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.mvp.AbstractMVPPresenter;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.view.GroupDetailView;

@UIComponent
public class GroupDetailPresenterImpl extends AbstractMVPPresenter implements
		GroupDetailPresenter {

	@Autowired
	private GroupService groupService;

	@Override
	public void save() {
		final GroupDetailView view = (GroupDetailView) getView();

		Group group = new Group();
		group.setName(view.getName());
		group.setDescription(view.getItemDescription());
		group.setKeywords(view.getKeywords());
		group.setSeoDescription(view.getSeoDescription());

		groupService.save(group);
	}

}
