package cz.jiripinkas.abcvids.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.jiripinkas.abcvids.annotation.UIComponent;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.mvp.AbstractMVPPresenter;
import cz.jiripinkas.abcvids.service.GroupService;

@UIComponent
public class GroupsPresenterImpl extends AbstractMVPPresenter implements GroupsPresenter {

	@Autowired
	private GroupService groupService;

	@Override
	public List<Group> findAll() {
		return groupService.findAll();
	}

}
