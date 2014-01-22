package cz.jiripinkas.abcvids.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.service.InitDbSettingsService;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SettingsService;
import cz.jiripinkas.abcvids.service.SitemapService;

@Controller
public class MyController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SitemapService sitemapService;
	
	@Autowired
	private SettingsService settingsService;

	@RequestMapping("/index")
	public String getGroups(Model model) {
		model.addAttribute("list", groupService.findAll());
		return "group-list";
	}

	@RequestMapping("/{service}/{shortName}")
	public String getItems(Model model, @PathVariable String service, @PathVariable String shortName) {
		if(service.equals(settingsService.findOne(InitDbSettingsService.SETTINGS_GROUP_URL_PART).getValue())) {
			model.addAttribute("group", groupService.findOne(shortName));
			return "item-list";
		} else {
			model.addAttribute("item", itemService.findOne(shortName));
			return "item";
		}
	}

	@RequestMapping("/sitemap.xml")
	@ResponseBody public String getSitemap() {
		String result = "";
		String[] sitemap = sitemapService.generateSitemap();
		for (String string : sitemap) {
			result += string;
		}
		return result;
	}
	
	@RequestMapping("/latest")
	public String getLatest(Model model) {
		List<Item> items = itemService.findAllLatest();
		model.addAttribute("items", items);
		return "latest";
	}
}
