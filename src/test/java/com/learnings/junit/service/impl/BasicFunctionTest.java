package com.learnings.junit.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-13
 */
public class BasicFunctionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBasic() {
        BasicFunction basicFunction = new BasicFunction();
        int actualResult = basicFunction.add(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void addEmpty() {
        BasicFunction basicFunction = new BasicFunction();
        int actualResult = basicFunction.add(null);
        int expectedResult = 0;
        assertEquals(actualResult,expectedResult);
    }
}