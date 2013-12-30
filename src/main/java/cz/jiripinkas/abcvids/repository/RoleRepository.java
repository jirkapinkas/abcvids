package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.abcvids.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
