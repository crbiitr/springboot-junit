package com.learnings.junit.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
public class JsonPathTest {

    @Test
    public void learning() {
        String responseString = "[{\"id\":1,\"name\":\"Chetan\",\"course\":\"BCA\"},{\"id\":2,\"name\":\"Aman\",\"course\":\"MCA\"},{\"id\":3,\"name\":\"Chaman\",\"course\":\"BTECH\"}]";
        DocumentContext context = JsonPath.parse(responseString);

        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1,2,3);

        System.out.println(context.read("$.[0]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Chetan')]").toString());
    }
}
