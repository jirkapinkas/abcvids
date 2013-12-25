package cz.jiripinkas.abcvids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	public void save(Group group) {
		groupRepository.save(group);
	}

}
