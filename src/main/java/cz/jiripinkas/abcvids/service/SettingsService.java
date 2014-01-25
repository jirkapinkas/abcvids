package cz.jiripinkas.abcvids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.repository.SettingsRepository;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	@Cacheable("settings")
	public List<Settings> findAll() {
		return settingsRepository.findAll(new Sort("id"));
	}

	@CacheEvict(value = "settings", allEntries = true)
	public Settings save(Settings settings) {
		return settingsRepository.save(settings);
	}

	@CacheEvict(value = "settings", allEntries = true)
	public void delete(Settings settings) {
		settingsRepository.delete(settings);
	}

	@Cacheable("settings")
	public Settings findOne(String key) {
		return settingsRepository.findByKey(key);
	}
}
