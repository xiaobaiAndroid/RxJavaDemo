package com.bzf.rxjavademo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilterOperationTest {

    private FilterOperation operation;

    @Before
    public void setUp() throws Exception {
        operation = new FilterOperation();
    }

    @Test
    public void testFilter() {
        operation.testFilter();
    }
}