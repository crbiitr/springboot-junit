package com.learnings.junit.repository;

import com.learnings.junit.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-17
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
