package com.learnings.junit.service.impl;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-14
 */

import com.learnings.junit.service.BasicDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class BasicDataServiceStub implements BasicDataService {

    @Override
    public int[] getAllValues() {
        return new int[]{1, 2, 3};
    }
}

class BasicDataServiceEmptyStub implements BasicDataService {

    @Override
    public int[] getAllValues() {
        return null;
    }
}
public class BasicFunctionStubTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBasic() {
        BasicFunction basicFunction = new BasicFunction();
        basicFunction.setBasicDataService(new BasicDataServiceStub());
        int actualResult = basicFunction.addUsingDataService();
        int expectedResult = 6;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void addEmpty() {
        BasicFunction basicFunction = new BasicFunction();
        basicFunction.setBasicDataService(new BasicDataServiceEmptyStub());
        int actualResult = basicFunction.addUsingDataService();
        int expectedResult = 0;
        assertEquals(actualResult,expectedResult);
    }
}
