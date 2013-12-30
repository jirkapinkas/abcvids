package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.abcvids.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
