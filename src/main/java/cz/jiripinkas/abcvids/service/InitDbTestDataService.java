package cz.jiripinkas.abcvids.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.annotation.DevProfile;
import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.repository.ItemRepository;
import cz.jiripinkas.abcvids.repository.RoleRepository;
import cz.jiripinkas.abcvids.repository.SettingsRepository;
import cz.jiripinkas.abcvids.util.MyUtil;

@DevProfile
@Transactional
@Service
public class InitDbTestDataService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private SettingsRepository settingsRepository;

	@PostConstruct
	public void init() {
		Group groupOracle = new Group();
		groupOracle.setName("Oracle database");
		groupOracle.setShortName(MyUtil.transformNameToShortName(groupOracle.getName()));
		groupOracle.setDescription("All about Oracle database");
		groupOracle.setKeywords("oracle, database");
		groupOracle.setSeoDescription("Oracle DB");
		groupOracle = groupRepository.save(groupOracle);

		Item itemInstallation = new Item();
		itemInstallation.setGroup(groupOracle);
		itemInstallation.setCreatedDate(new Date());
		itemInstallation.setName("Oracle XE installation");
		itemInstallation.setShortName(MyUtil.transformNameToShortName(itemInstallation.getName()));
		itemInstallation.setDescription("How to install Oracle XE");
		itemInstallation.setSeoDescription("Installing Oracle XE");
		itemInstallation.setKeywords("oracle, installation");
		itemInstallation.setUrl("http://youtube.com/");
		itemRepository.save(itemInstallation);

		Item itemConnect = new Item();
		itemConnect.setGroup(groupOracle);
		itemConnect.setCreatedDate(new Date());
		itemConnect.setName("Connecting to Oracle XE database");
		itemConnect.setShortName(MyUtil.transformNameToShortName(itemConnect.getName()));
		itemConnect.setDescription("How to connect to Oracle XE database using SQL Developer");
		itemConnect.setSeoDescription("Connecting to Oracle db.");
		itemConnect.setKeywords("oracle, connection");
		itemConnect.setUrl("http://youtube.com/");
		itemRepository.save(itemConnect);

		{
			Settings settings = new Settings();
			settings.setKey("HomepageWelcomeHeader");
			settings.setValue("Categories");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("HomepageWelcomeParagraph");
			settings.setValue("Welcome to SQL Vids, where are video tutorials about SQL language, Oracle database and SQL Developer");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("LatestHeader");
			settings.setValue("Latest posts");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("TopLatestHeader");
			settings.setValue("Latest posts");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("AllLatestLink");
			settings.setValue("All latest posts");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("GoogleSiteVerification");
			settings.setValue("<meta name=\"google-site-verification\" content=\"rYaxPa0fLkhNvtDpke81BCrYbqJU6qSnrIn5g6IEcTE\" />");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("GoogleAnalytics");
			settings.setValue("<script>\n" + "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n"
					+ "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n"
					+ "  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + "\n" + "  ga('create', 'UA-4384433-14', 'sqlvids.com');\n" + "  ga('send', 'pageview');\n"
					+ "\n" + "</script>");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("Copyright");
			settings.setValue("&copy; <a href=\"http://plus.google.com/100661368478614117231\" target=\"_blank\">Jirka Pinkas</a>, professional Java and Oracle DB trainer. All Rights Reserved.");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("OtherProjects");
			settings.setValue("My other projects: \n" + "<a href=\"http://www.javavids.com\" target=\"_blank\">Java video tutorials</a>\n"
					+ "<a href=\"http://www.java-skoleni.cz\" target=\"_blank\">Java školení (in Czech language)</a>\n"
					+ "<a href=\"http://www.sql-skoleni.cz\" target=\"_blank\">SQL školení (in Czech language)</a>\n");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("HomepageSeoKeywords");
			settings.setValue("sql, sql video, sql tutorial, online, free");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("HomepageSeoDescription");
			settings.setValue("Free online video tutorials about SQL and Oracle database.");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("AdsenseBannerTop");
			settings.setValue("<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids banner -->\n" + "<ins class=\"adsbygoogle\"\n"
					+ "     style=\"display:inline-block;width:728px;height:90px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"2998000806\"></ins>\n"
					+ "<script>\n" + "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("AdsenseBannerLeft");
			settings.setValue("<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids left -->\n" + "<ins class=\"adsbygoogle\"\n"
					+ "     style=\"display:inline-block;width:160px;height:600px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"7428200407\"></ins>\n"
					+ "<script>\n" + "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("AdsenseBannerRight");
			settings.setValue("<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids right -->\n" + "<ins class=\"adsbygoogle\"\n"
					+ "     style=\"display:inline-block;width:336px;height:280px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"8904933606\"></ins>\n"
					+ "<script>\n" + "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
			settingsRepository.save(settings);
		}

		{
			Settings settings = new Settings();
			settings.setKey("Disqus");
			settings.setValue("<div id=\"disqus_thread\"></div>\n" + "<script type=\"text/javascript\">\n" + "    /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */\n"
					+ "    var disqus_shortname = 'sqlvids'; // required: replace example with your forum shortname\n" + "    /* * * DON'T EDIT BELOW THIS LINE * * */\n" + "    (function() {\n"
					+ "        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;\n" + "        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';\n"
					+ "        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);\n" + "    })();\n" + "</script>\n");
			settingsRepository.save(settings);
		}

	}
}
