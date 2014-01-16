package cz.jiripinkas.abcvids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.repository.ItemRepository;
import cz.jiripinkas.jsitemapgenerator.WebPage;
import cz.jiripinkas.jsitemapgenerator.WebSitemapGenerator;

@Service
public class SitemapService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private GroupRepository groupRepository;

	public String[] generateSitemap() {
		WebSitemapGenerator webSitemapGenerator = new WebSitemapGenerator("http://www.sqlvids.com");
		webSitemapGenerator.addPage(new WebPage().setName("").setPriority(1.0));
		List<Group> groups = groupRepository.findAll();
		for (Group group : groups) {
			webSitemapGenerator.addPage(new WebPage().setName("tutorial/" + group.getShortName() + ".html").setPriority(0.8));
		}
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			webSitemapGenerator.addPage(new WebPage().setName("video/" + item.getShortName() + ".html").setPriority(0.6));
		}
		return webSitemapGenerator.constructSitemap();
	}
}