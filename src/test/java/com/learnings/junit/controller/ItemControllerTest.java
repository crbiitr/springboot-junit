package com.learnings.junit.controller;

import com.learnings.junit.model.Item;
import com.learnings.junit.service.impl.ItemBusinessServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-16
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    /* We need this for calling URL */
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServiceImpl businessService;

    @Test
    public void itemBasic() throws Exception {

        // Preparing request using MockMvcRequestBuilders
        RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);

        // Hitting request using MockMvc
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"TV\",\"price\":20000,\"quantity\":1,\"value\":0}"))
                .andReturn();
    }

    @Test
    public void itemFromBusinessServiceBasic() throws Exception {

        when(businessService.getStubItemObject()).thenReturn(new Item(2, "AC", 20000, 1));
        // Preparing request using MockMvcRequestBuilders
        RequestBuilder request = MockMvcRequestBuilders.get("/item-business").accept(MediaType.APPLICATION_JSON);

        // Hitting request using MockMvc
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"AC\",\"price\":20000,\"quantity\":1,\"value\":0}"))
                .andReturn();
    }

    @Test
    public void itemFromDatabase() throws Exception {

        when(businessService.getAllItemsFromDatabase()).thenReturn(Arrays.asList(new Item(2, "AC", 20000, 1),
                new Item(1, "TV", 20000, 1)));

        // Preparing request using MockMvcRequestBuilders
        RequestBuilder request = MockMvcRequestBuilders.get("/item-list-from-database").accept(MediaType.APPLICATION_JSON);

        // Hitting request using MockMvc
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:AC,price:20000,quantity:1,value:20000},{id:1,name:TV,price:20000,quantity:1,value:20000}]"))
                .andReturn();
    }
}