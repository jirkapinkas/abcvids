package cz.jiripinkas.abcvids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SitemapService;

@Controller
public class VidsController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SitemapService sitemapService;

	@RequestMapping("/index")
	public String getGroups(Model model) {
		model.addAttribute("list", groupService.findAll());
		return "group-list";
	}

	@RequestMapping("/tutorial/{shortName}")
	public String getItems(Model model, @PathVariable String shortName) {
		model.addAttribute("group", groupService.findOne(shortName));
		return "item-list";
	}

	@RequestMapping("/video/{shortName}")
	public String getVideo(Model model, @PathVariable String shortName) {
		model.addAttribute("item", itemService.findOne(shortName));
		return "item";
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
}
