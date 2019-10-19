package com.learnings.junit.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> list = Arrays.asList(10, 20, 30);

        assertThat(list).hasSize(3)
                .contains(20, 30)
                .allMatch(x -> x > 5)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);

        assertThat("").isEmpty();
        assertThat("ABCDEF")
                .contains("DE")
                .startsWith("AB")
                .endsWith("EF");

        // FOLLOWING IS USING HAMCREST LIBRARY
        /*assertThat(list,hasSize(3));
        assertThat(list,hasItems(20,30));
        assertThat(list,everyItem(greaterThan(5)));
        assertThat(list,everyItem(lessThan(100)));


        assertThat("", isEmptyString());
        assertThat("ABCDEF", containsString("CDE"));
        assertThat("ABCDEF", startsWith("AB"));
        assertThat("ABCDEF", endsWith("DEF"));*/
    }
}
