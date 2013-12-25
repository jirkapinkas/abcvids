package cz.jiripinkas.abcvids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.abcvids.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
