package com.bzf.rxjavademo;

import org.junit.Before;
import org.junit.Test;

public class ConversionOperationTest {

    private ConversionOperation operation;

    @Before
    public void setUp() throws Exception {
        operation = new ConversionOperation();
    }

    @Test
    public void testMap() {
        operation.testMap();
    }

    @Test
    public void testFlatMap(){
        operation.testFlatMap();
    }

    @Test
    public void testConcatMap(){
        operation.testConcatMap();
    }

    @Test
    public void testGroupBy(){
        operation.testGroupBy();
    }
}