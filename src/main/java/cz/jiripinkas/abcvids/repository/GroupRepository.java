package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.abcvids.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
