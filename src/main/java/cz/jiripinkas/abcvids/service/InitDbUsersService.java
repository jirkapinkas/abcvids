package cz.jiripinkas.abcvids.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.entity.Role;
import cz.jiripinkas.abcvids.entity.User;
import cz.jiripinkas.abcvids.repository.RoleRepository;
import cz.jiripinkas.abcvids.repository.UserRepository;

@Transactional
@Service
public class InitDbUsersService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {

		Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
		if (roleAdmin == null) {
			roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
		}

		User userAdmin = userRepository.findByName("admin");
		if (userAdmin == null) {
			userAdmin = new User();
			userAdmin.setName("admin");
			userAdmin.setPassword(userService.encodePassword("admin"));
			userAdmin.setEnabled(true);
			List<Role> userRoleList = new ArrayList<Role>();
			userRoleList.add(roleAdmin);
			userAdmin.setRoles(userRoleList);
			userAdmin = userRepository.save(userAdmin);
		}
	}
}
