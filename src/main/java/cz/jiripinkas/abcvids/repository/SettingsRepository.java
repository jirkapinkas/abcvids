package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.abcvids.entity.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Integer> {

}
