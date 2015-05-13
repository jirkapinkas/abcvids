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

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.service.GroupService;

@Controller
@RequestMapping("/admin")
public class AdminGroupController {

	@Autowired
	private GroupService groupService;

	@ModelAttribute
	public Group construct() {
		return new Group();
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

	@RequestMapping("/group-form")
	public String showAdd(Model model) {
		model.addAttribute("images", constructImages());
		return "admin-group-form";
	}

	@RequestMapping(value = "/group-form", method = RequestMethod.POST)
	public void add(@ModelAttribute Group group, HttpServletResponse response, @RequestParam String image) throws IOException {
		groupService.save(group, image);
		response.sendRedirect("/index.html");
	}

	@RequestMapping(value = "/group/delete", method = RequestMethod.POST)
	public void remove(@RequestParam int id, HttpServletResponse response) throws IOException {
		groupService.delete(id);
		response.sendRedirect("/index.html");
	}
	
	@RequestMapping("/group/edit")
	public String showEdit(@RequestParam int id, Model model) {
		model.addAttribute("group", groupService.findOne(id));
		model.addAttribute("images", constructImages());
		return "admin-group-form";
	}
	
	@RequestMapping(value = "/group/edit", method = RequestMethod.POST)
	public void edit(@RequestParam int id, @ModelAttribute Group group, HttpServletResponse response, @RequestParam String image) throws IOException {
		group.setId(id);
		groupService.edit(group, image);
		response.sendRedirect("/index.html");
	}

}
