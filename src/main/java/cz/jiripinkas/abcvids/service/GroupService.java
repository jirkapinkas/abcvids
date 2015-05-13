package cz.jiripinkas.abcvids.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.util.MyUtil;

@Transactional
@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	public List<Group> findAll() {
		return groupRepository.findAll(new Sort("id"));
	}

	public void save(Group group, String imageName) throws IOException {
		if (group.getShortName() == null || "".equals(group.getShortName())) {
			group.setShortName(MyUtil.transformNameToShortName(group.getName()));
		}
		if (imageName != null) {
			group.setImage(imageName + ".png");
		}
		groupRepository.save(group);
	}

	public void delete(int groupId) {
		groupRepository.delete(groupId);
	}

	public Group findOne(int groupId) {
		return groupRepository.findOne(groupId);
	}

	public Group findOne(String shortName) {
		return groupRepository.findByShortName(shortName);
	}

	public void edit(Group group, String imageName) {
		Group managedGroup = groupRepository.findOne(group.getId());
		managedGroup.setDescription(group.getDescription());
		managedGroup.setKeywords(group.getKeywords());
		managedGroup.setName(group.getName());
		managedGroup.setSeoDescription(group.getSeoDescription());
		managedGroup.setShortName(group.getShortName());
		if (imageName != null) {
			managedGroup.setImage(imageName + ".png");
		}
		groupRepository.save(managedGroup);
	}

}
