package com.learnings.junit.repository;

import com.learnings.junit.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> itemList = itemRepository.findAll();
        assertEquals(2,itemList.size());
    }

}