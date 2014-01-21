package cz.jiripinkas.abcvids.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.service.ItemService;
import cz.jiripinkas.abcvids.service.SettingsService;

public class SettingsInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private ItemService itemService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			List<Settings> list = settingsService.findAll();
			for (Settings settings : list) {
				modelAndView.getModelMap().addAttribute(settings.getKey(), settings.getValue());
			}
			modelAndView.getModelMap().addAttribute("latestVideos", itemService.findLatest(3));
		}
	}
}
