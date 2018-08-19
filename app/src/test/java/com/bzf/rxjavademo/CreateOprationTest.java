package com.bzf.rxjavademo;

import org.junit.Before;
import org.junit.Test;

public class CreateOprationTest {

    private CreateOperation opration;

    @Before
    public void setUp() throws Exception {
        opration = new CreateOperation();
    }

    @Test
    public void testInterval() {
        opration.testInterval();
    }

    @Test
    public void testRange(){
        opration.testRange();
    }

    @Test
    public void testTimer(){
        opration.testTimer();
    }
}