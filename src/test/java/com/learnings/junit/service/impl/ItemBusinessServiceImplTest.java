package com.learnings.junit.service.impl;

import com.learnings.junit.model.Item;
import com.learnings.junit.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceImplTest {
    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemBusinessServiceImpl itemBusinessService;

    @Test
    public void calculateSumUsingDataServiceBasic() {

        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "TV", 20000, 1), new Item(2, "AC", 50000, 1)));

        List<Item> itemList = itemBusinessService.getAllItemsFromDatabase();

        assertEquals(20000,itemList.get(0).getValue());
        assertEquals(50000,itemList.get(1).getValue());

    }


}