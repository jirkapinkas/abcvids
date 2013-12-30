package cz.jiripinkas.abcvids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.abcvids.entity.User;
import cz.jiripinkas.abcvids.repository.UserRepository;

@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public void changePassword(User user, String password) {
		user.setPassword(encodePassword(password));
		userRepository.save(user);
	}

	public User findOne(String name) {
		return userRepository.findByName(name);
	}
}
