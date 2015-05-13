package cz.jiripinkas.abcvids.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.service.GroupService;
import cz.jiripinkas.abcvids.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private GroupService groupService;

	@ModelAttribute
	public Item construct() {
		return new Item();
	}
	
	private List<String> constructImages() {
		List<String> images = new ArrayList<String>();
		images.add("blog-post");
		images.add("english-flag");
		images.add("envelope");
		images.add("german-flag");
		images.add("group-default");
		images.add("item-default");
		images.add("oracle");
		images.add("sql-developer");
		return images;
	}

	@RequestMapping("/item-form")
	public String showAdd(Model model, @RequestParam int groupId) {
		model.addAttribute("images", constructImages());
		return "admin-item-form";
	}

	@RequestMapping(value = "/item-form", method = RequestMethod.POST)
	public void add(@ModelAttribute Item item, HttpServletResponse response, @RequestParam String image, @RequestParam int groupId) throws IOException {
		itemService.save(item, groupId, image);
		response.sendRedirect("/tutorial/" + groupService.findOne(groupId).getShortName() + ".html");
	}

	@RequestMapping(value = "/item/delete", method = RequestMethod.POST)
	public void remove(@RequestParam int id, HttpServletResponse response, @RequestParam int groupId) throws IOException {
		itemService.delete(id);
		response.sendRedirect("/tutorial/" + groupService.findOne(groupId).getShortName() + ".html");
	}
	
	@RequestMapping("/item/edit")
	public String showEdit(@RequestParam int id, Model model) {
		model.addAttribute("item", itemService.findOne(id));
		model.addAttribute("images", constructImages());
		return "admin-item-form";
	}
	
	@RequestMapping(value = "/item/edit", method = RequestMethod.POST)
	public void edit(@RequestParam int id, @ModelAttribute Item item, HttpServletResponse response, @RequestParam String image, @RequestParam int groupId) throws IOException {
		item.setId(id);
		itemService.edit(item, image);
		response.sendRedirect("/tutorial/" + groupService.findOne(groupId).getShortName() + ".html");
	}

}
