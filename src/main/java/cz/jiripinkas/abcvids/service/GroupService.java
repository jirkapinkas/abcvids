package cz.jiripinkas.abcvids.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.dto.GroupOverviewDto;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.util.MyUtil;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private DozerBeanMapper mapper;

	public List<GroupOverviewDto> findAllOverview() {
		List<Group> groups = groupRepository.findAll();
		ArrayList<GroupOverviewDto> dtos = new ArrayList<GroupOverviewDto>();
		for (Group group : groups) {
			dtos.add(mapper.map(group, GroupOverviewDto.class));
		}
		return dtos;
	}
	
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	public void save(Group group) {
		if(group.getShortName() == null || "".equals(group.getShortName())) {
			group.setShortName(MyUtil.transformNameToShortName(group.getName()));
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

}
