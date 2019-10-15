package com.learnings.junit.service.impl;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-14
 */

public class ListMockTesting {
    List<String> listMock = mock(List.class);

    @Test
    public void listSizeBasic() {
        when(listMock.size()).thenReturn(5);
        assertEquals(listMock.size(),5);
    }

    @Test
    public void listSizeWithDifferentValues() {
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(listMock.size(),5);
        assertEquals(listMock.size(),10);
    }

    @Test
    public void returnWithParameter() {
        when(listMock.get(0)).thenReturn("Hi");
        assertEquals("Hi", listMock.get(0));
        /*
        * NOTE: when we are calling any objject with some parameter, It must be same other wise we will get default values.
        * Object: null
        * numeric: 0
        * boolean: false
        * Collections: empty collection
        */
        //assertEquals("Hi",listMock.get(1));
    }

    /*
    * Use of anyInt().
    * Check ArgumentMatchers class.
    */
    @Test
    public void returnWithGenericParameter() {
        when(listMock.get(anyInt())).thenReturn("Hi");
        assertEquals("Hi", listMock.get(0));
        assertEquals("Hi", listMock.get(1));
    }

    @Test
    public void verification(){
        // SUT
        String value = listMock.get(0);

        // Verify
        verify(listMock).get(0);
        verify(listMock).get(anyInt());
        verify(listMock,times(1)).get(anyInt());
    }

    @Test
    public void verification2(){
        // SUT
        String value1 = listMock.get(0);
        String value2 = listMock.get(1);

        // Verify
        verify(listMock).get(0);
        verify(listMock,times(2)).get(anyInt());
        verify(listMock,atLeast(1)).get(anyInt());
        verify(listMock,atMost(2)).get(anyInt());
        verify(listMock,never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //SUT
        listMock.add("Chetan");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        assertEquals("Chetan",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        //SUT
        listMock.add("Chetan1");
        listMock.add("Chetan2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(listMock,times(2)).add(captor.capture());

        List<String> values = captor.getAllValues();

        assertEquals("Chetan1",values.get(0));
        assertEquals("Chetan2",values.get(1));
    }

    /*
    * A mock does not retain behavior(code) of the original class.
    */
    @Test
    public void mocking(){
        ArrayList<String> arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0

        arrayListMock.add("data1");
        arrayListMock.add("data2");

        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 5

    }

    /*
     * A mock does not retain behavior(code) of the original class.
     */
    @Test
    public void spying(){
        ArrayList<String> arrayListSpy = spy(ArrayList.class);
        //NullPointerException, so first add, bcz it is not mock object it is a spy object
        //System.out.println(arrayListMock.get(0)); // NullPointerException

        arrayListSpy.add("data0");
        System.out.println(arrayListSpy.get(0)); // data0
        System.out.println(arrayListSpy.size()); // 1

        arrayListSpy.add("data1");
        arrayListSpy.add("data2");

        System.out.println(arrayListSpy.size()); // 3

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        arrayListSpy.add("data3");
        System.out.println(arrayListSpy.size()); // 5

        verify(arrayListSpy).add("data3");
        //verify(arrayListSpy).add("data4"); // failed case

    }
}
