package cz.jiripinkas.abcvids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.dto.ItemOverviewDto;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.repository.ItemRepository;
import cz.jiripinkas.abcvids.util.MyUtil;

@Transactional
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private DozerBeanMapper mapper;

	public List<ItemOverviewDto> findAllOverview(int groupId) {
		List<Item> list = itemRepository.findByGroupId(groupId);
		List<ItemOverviewDto> result = new ArrayList<ItemOverviewDto>();
		for (Item item : list) {
			result.add(mapper.map(item, ItemOverviewDto.class));
		}
		return result;
	}

	public List<Item> findAll(int groupId) {
		return itemRepository.findByGroupId(groupId);
	}

	@CacheEvict(value = "topItems", allEntries = true)
	public void save(Item item, int groupId) {
		item.setCreatedDate(new Date());
		item.setGroup(groupRepository.findOne(groupId));
		if (item.getShortName() == null || "".equals(item.getShortName())) {
			item.setShortName(MyUtil.transformNameToShortName(item.getName()));
		}
		itemRepository.save(item);
	}

	@CacheEvict(value = "topItems", allEntries = true)
	public void delete(int itemId) {
		itemRepository.delete(itemId);
	}

	public Item findOne(int itemId) {
		return itemRepository.findOne(itemId);
	}

	public Item findOne(String shortName) {
		return itemRepository.findByShortName(shortName);
	}

	@Cacheable("topItems")
	public List<Item> findLatest(int size) {
		return itemRepository.findAll(new PageRequest(0, size, Direction.DESC, "createdDate")).getContent();
	}

	public List<Item> findAllLatest() {
		return itemRepository.findAll(new Sort(Direction.DESC, "createdDate"));
	}

}
