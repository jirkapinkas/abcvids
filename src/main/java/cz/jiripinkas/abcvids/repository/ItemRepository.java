package cz.jiripinkas.abcvids.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.jiripinkas.abcvids.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query("select i from Item i join fetch i.group where i.group.id = :groupId order by i.createdDate")
	List<Item> findByGroupId(@Param("groupId") int groupId);

	@Query("select i from Item i join fetch i.group where i.shortName = :shortName")
	Item findByShortName(@Param("shortName") String shortName);

}
