package cz.jiripinkas.abcvids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.dto.ItemOverviewDto;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.repository.ItemRepository;

@Transactional
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private DozerBeanMapper mapper;

	public List<ItemOverviewDto> findAll(int groupId) {
		List<Item> list = itemRepository.findByGroupId(groupId);
		List<ItemOverviewDto> result = new ArrayList<ItemOverviewDto>();
		for (Item item : list) {
			result.add(mapper.map(item, ItemOverviewDto.class));
		}
		return result;
	}
	
	public void save(Item item, int groupId) {
		item.setCreatedDate(new Date());
		item.setGroup(groupRepository.findOne(groupId));
		itemRepository.save(item);
	}

	public void delete(int itemId) {
		itemRepository.delete(itemId);
	}

	public Item findOne(int itemId) {
		return itemRepository.findOne(itemId);
	}

}
