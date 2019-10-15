package com.learnings.junit.service.impl;

import com.learnings.junit.service.BasicDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-14
 */
@RunWith(MockitoJUnitRunner.class)
public class BasicFunctionMockTest {

    /*
        BasicFunction basicFunction = new BasicFunction();
        //Mocking dataService
        BasicDataService basicDataServiceMock = mock(BasicDataService.class);

        @InjectMocks is setting BasicDataService into BasicFunction class
        When using @RunWith(MockitoJUnitRunner.class) than don't need to use @Before function

        @Before
        public void before() {
            basicFunction.setBasicDataService(basicDataServiceMock);
        }
    */

    @InjectMocks
    BasicFunction basicFunction;
    @Mock
    BasicDataService basicDataServiceMock;


    @Test
    public void addBasic() {
        when(basicDataServiceMock.getAllValues()).thenReturn(new int[]{1, 2, 3});
        assertEquals(basicFunction.addUsingDataService(), 6);
    }

    @Test
    public void addEmpty() {
        when(basicDataServiceMock.getAllValues()).thenReturn(new int[]{});
        assertEquals(basicFunction.addUsingDataService(), 0);
    }

    @Test
    public void addNull() {
        when(basicDataServiceMock.getAllValues()).thenReturn(null);
        assertEquals(basicFunction.addUsingDataService(), 0);
    }
}
