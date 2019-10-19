package com.learnings.junit.spike;

import org.hamcrest.core.StringEndsWith;
import org.hamcrest.text.IsEmptyString;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-18
 */
public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> list = Arrays.asList(10,20,30);

        assertThat(list,hasSize(3));
        assertThat(list,hasItems(20,30));
        assertThat(list,everyItem(greaterThan(5)));
        assertThat(list,everyItem(lessThan(100)));


        assertThat("", isEmptyString());
        assertThat("ABCDEF", containsString("CDE"));
        assertThat("ABCDEF", startsWith("AB"));
        assertThat("ABCDEF", endsWith("DEF"));
    }
}
