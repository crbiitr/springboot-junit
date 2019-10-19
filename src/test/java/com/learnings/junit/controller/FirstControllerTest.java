package com.learnings.junit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-16
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FirstController.class)
public class FirstControllerTest {

    /* We need this for calling URL */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloBasic() throws Exception {

        // Preparing request using MockMvcRequestBuilders
        RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);

        // Hitting request using MockMvc
        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals("Hi Chetan",result.getResponse().getContentAsString());

    }

    @Test
    public void helloBasicUsingMatchers() throws Exception {

        // Preparing request using MockMvcRequestBuilders
        RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);

        // Hitting request using MockMvc
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hi Chetan"))
                .andReturn();

        // No need assertEquals here because we are checking status and content using  "MockMvcResultMatchers"
        // assertEquals("Hi Chetan",result.getResponse().getContentAsString());

    }
}