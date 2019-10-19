package com.learnings.junit.service.impl;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-16
 */
public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"TV\",\"price\":20000,\"quantity\":1,\"value\":0}";

    /* Extra space in the json format is ignore by JSONAssert */
    @Test
    public void jsonAssertStrictTrue() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"TV\",\"price\":20000,\"quantity\":1,\"value\":0}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    /* In case of strict: false, key-value will be ignore if not present */
    @Test
    public void jsonAssertStrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"TV\",\"price\":20000,\"quantity\":1}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    public void jsonAssertWithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1, name:TV, price:20000, quantity:1}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
