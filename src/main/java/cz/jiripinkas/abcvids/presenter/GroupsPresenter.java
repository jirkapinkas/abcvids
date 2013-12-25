package cz.jiripinkas.abcvids.presenter;

import java.util.List;

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.mvp.MVPPresenter;

public interface GroupsPresenter extends MVPPresenter {

	List<Group> findAll();

}
