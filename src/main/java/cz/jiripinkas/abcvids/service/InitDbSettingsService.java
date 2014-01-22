package cz.jiripinkas.abcvids.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.repository.SettingsRepository;

@Service
public class InitDbSettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	public static final String SETTINGS_GROUP_URL_PART = "GroupUrlPart";
	public static final String SETTINGS_ITEM_URL_PART = "ItemUrlPart";
	public static final String SETTINGS_WEB_SITE_URL = "WebSiteUrl";

	@PostConstruct
	public void init() {
		addSettings(SETTINGS_GROUP_URL_PART, "tutorial");
		addSettings(SETTINGS_ITEM_URL_PART, "video");
		addSettings(SETTINGS_WEB_SITE_URL, "http://www.sqlvids.com");
		addSettings("ImageSiteLogo", "logo-default.png");
		addSettings("ImageItemLogo", "item-default.png");
		addSettings("ImageGroupLogo", "group-default.jpg");
		addSettings("HomepageWelcomeHeader", "Categories");
		addSettings("DateFormat", "M/d/yyyy");
		addSettings("HomeButton", "Home");
		addSettings("SiteName", "SQL video tutorials");
		addSettings("HomepageWelcomeParagraph", "Welcome to SQL Vids, where are video tutorials about SQL language, Oracle database and SQL Developer");
		addSettings("LatestHeader", "Latest posts");
		addSettings("TopLatestHeader", "Latest posts");
		addSettings("AllLatestLink", "All latest posts");
		addSettings("GoogleSiteVerification", "<meta name=\"google-site-verification\" content=\"rYaxPa0fLkhNvtDpke81BCrYbqJU6qSnrIn5g6IEcTE\" />");
		addSettings("GoogleAnalytics", "<script>\n" + "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n"
				+ "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n"
				+ "  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + "\n" + "  ga('create', 'UA-4384433-14', 'sqlvids.com');\n" + "  ga('send', 'pageview');\n"
				+ "\n" + "</script>");
		addSettings("Copyright", "&copy; <a href=\"http://plus.google.com/100661368478614117231\" target=\"_blank\">Jirka Pinkas</a>, professional Java and Oracle DB trainer. All Rights Reserved.");
		addSettings("OtherProjects", "My other projects: \n" + "<a href=\"http://www.javavids.com\" target=\"_blank\">Java video tutorials</a>\n"
				+ "<a href=\"http://www.java-skoleni.cz\" target=\"_blank\">Java školení (in Czech language)</a>\n"
				+ "<a href=\"http://www.sql-skoleni.cz\" target=\"_blank\">SQL školení (in Czech language)</a>\n");
		addSettings("HomepageSeoKeywords", "sql, sql video, sql tutorial, online, free");
		addSettings("HomepageSeoDescription", "Free online video tutorials about SQL and Oracle database.");
		addSettings("AdsenseBannerTop", "<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids banner -->\n" + "<ins class=\"adsbygoogle\"\n"
				+ "     style=\"display:inline-block;width:728px;height:90px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"2998000806\"></ins>\n" + "<script>\n"
				+ "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
		addSettings("AdsenseBannerLeft", "<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids left -->\n" + "<ins class=\"adsbygoogle\"\n"
				+ "     style=\"display:inline-block;width:160px;height:600px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"7428200407\"></ins>\n" + "<script>\n"
				+ "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
		addSettings("AdsenseBannerRight", "<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + "<!-- sqlvids right -->\n" + "<ins class=\"adsbygoogle\"\n"
				+ "     style=\"display:inline-block;width:336px;height:280px\"\n" + "     data-ad-client=\"ca-pub-7085637172523095\"\n" + "     data-ad-slot=\"8904933606\"></ins>\n" + "<script>\n"
				+ "(adsbygoogle = window.adsbygoogle || []).push({});\n" + "</script>\n");
		addSettings("Disqus", "<div id=\"disqus_thread\"></div>\n" + "<script type=\"text/javascript\">\n" + "    /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */\n"
				+ "    var disqus_shortname = 'sqlvids'; // required: replace example with your forum shortname\n" + "    /* * * DON'T EDIT BELOW THIS LINE * * */\n" + "    (function() {\n"
				+ "        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;\n" + "        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';\n"
				+ "        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);\n" + "    })();\n" + "</script>\n");
	}

	public void addSettings(String key, String value) {
		if (settingsRepository.findByKey(key) == null) {
			Settings settings = new Settings();
			settings.setKey(key);
			settings.setValue(value);
			settingsRepository.save(settings);
		}
	}
}
