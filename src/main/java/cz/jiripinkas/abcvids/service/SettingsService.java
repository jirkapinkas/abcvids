package cz.jiripinkas.abcvids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cz.jiripinkas.abcvids.entity.Settings;
import cz.jiripinkas.abcvids.repository.SettingsRepository;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	public Settings findByKey(String key) {
		return settingsRepository.findByKey(key);
	}

	public List<Settings> findAll() {
		return settingsRepository.findAll(new Sort("id"));
	}

	public Settings save(Settings settings) {
		return settingsRepository.save(settings);
	}

	public void delete(Settings settings) {
		settingsRepository.delete(settings);
	}
}
