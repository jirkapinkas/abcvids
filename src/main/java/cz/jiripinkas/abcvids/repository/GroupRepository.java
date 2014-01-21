package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.jiripinkas.abcvids.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	@Query("select g from Group g left join fetch g.items where g.shortName = :shortName")
	Group findByShortName(@Param("shortName") String shortName);

}
