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

	@CacheEvict("settings")
	public Settings save(Settings settings) {
		return settingsRepository.save(settings);
	}

	@CacheEvict("settings")
	public void delete(Settings settings) {
		settingsRepository.delete(settings);
	}
}
