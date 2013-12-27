package cz.jiripinkas.abcvids.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.entity.Group;
import cz.jiripinkas.abcvids.entity.Item;
import cz.jiripinkas.abcvids.repository.GroupRepository;
import cz.jiripinkas.abcvids.repository.ItemRepository;
import cz.jiripinkas.abcvids.util.MyUtil;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private GroupRepository groupRepository;

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

	}
}
