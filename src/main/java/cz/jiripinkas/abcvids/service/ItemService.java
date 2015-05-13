package cz.jiripinkas.abcvids.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.entity.Group;
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

	public List<Item> findAll(int groupId) {
		return itemRepository.findByGroupId(groupId);
	}

	@CacheEvict(value = "topItems", allEntries = true)
	public void save(Item item, int groupId, String imageName) {
		item.setCreatedDate(new Date());
		item.setGroup(groupRepository.findOne(groupId));
		if (item.getShortName() == null || "".equals(item.getShortName())) {
			item.setShortName(MyUtil.transformNameToShortName(item.getName()));
		}
		if (imageName != null) {
			item.setImage(imageName + ".png");
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

	public void edit(Item item, String imageName) {
		Item managedItem = itemRepository.findOne(item.getId());
		managedItem.setDescription(item.getDescription());
		managedItem.setKeywords(item.getKeywords());
		managedItem.setName(item.getName());
		managedItem.setSeoDescription(item.getSeoDescription());
		managedItem.setShortName(item.getShortName());
		managedItem.setUrl(item.getUrl());
		if (imageName != null) {
			managedItem.setImage(imageName + ".png");
		}
		itemRepository.save(managedItem);
	}

}
