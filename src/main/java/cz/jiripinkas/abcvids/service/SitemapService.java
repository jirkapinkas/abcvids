package cz.jiripinkas.abcvids.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	@Autowired
	private SettingsService settingsService;

	private Date lastGooglePing;

	public String[] generateSitemap() {
		WebSitemapGenerator webSitemapGenerator = new WebSitemapGenerator(settingsService.findOne(InitDbSettingsService.SETTINGS_WEB_SITE_URL).getValue());
		webSitemapGenerator.addPage(new WebPage().setName("").setPriority(1.0));
		webSitemapGenerator.addPage(new WebPage().setName("latest.html").setPriority(0.9));
		List<Group> groups = groupRepository.findAll();
		for (Group group : groups) {
			webSitemapGenerator.addPage(new WebPage().setName(settingsService.findOne(InitDbSettingsService.SETTINGS_GROUP_URL_PART).getValue() + "/" + group.getShortName() + ".html")
					.setPriority(0.8));
		}
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			webSitemapGenerator.addPage(new WebPage().setName(settingsService.findOne(InitDbSettingsService.SETTINGS_ITEM_URL_PART).getValue() + "/" + item.getShortName() + ".html").setPriority(0.6));
		}
		return webSitemapGenerator.constructSitemap();
	}

	@Scheduled(cron = "0 1 * * * *")
	public void pingGoogle() {
		if (lastGooglePing == null) {
			// restarted application
			System.out.println("ping google!");
			new WebSitemapGenerator(settingsService.findOne(InitDbSettingsService.SETTINGS_WEB_SITE_URL).getValue()).pingGoogle();
			lastGooglePing = new Date();
		} else {
			// is last google ping older than newer items?
			boolean willPingGoogle = false;
			List<Item> items = itemRepository.findAll();
			for (Item item : items) {
				if (item.getCreatedDate().compareTo(lastGooglePing) > 0) {
					willPingGoogle = true;
				}
			}
			if (willPingGoogle) {
				System.out.println("ping google!");
				new WebSitemapGenerator(settingsService.findOne(InitDbSettingsService.SETTINGS_WEB_SITE_URL).getValue()).pingGoogle();
			}
		}
	}
}
