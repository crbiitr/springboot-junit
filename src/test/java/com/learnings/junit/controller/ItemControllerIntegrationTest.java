package com.learnings.junit.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String object = testRestTemplate.getForObject("/item-list-from-database", String.class);
        JSONAssert.assertEquals("[{id:1},{id:2}]",object,false);
    }

}