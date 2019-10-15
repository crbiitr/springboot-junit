package com.learnings.junit.service.impl;

import com.learnings.junit.service.BasicDataService;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-13
 */
public class BasicFunction {
    private BasicDataService basicDataService;

    public void setBasicDataService(BasicDataService basicDataService) {
        this.basicDataService = basicDataService;
    }

    public int add(int[] values) {
        int sum = 0;
        if (values == null) {
            return sum;
        }
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public int addUsingDataService() {
        int sum = 0;
        int[] values = basicDataService.getAllValues();
        if (values == null) {
            return sum;
        }
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
