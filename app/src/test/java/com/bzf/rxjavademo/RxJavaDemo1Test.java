package com.bzf.rxjavademo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RxJavaDemo1Test {

    private RxJavaDemo1 demo1;

    @Before
    public void setUp() throws Exception {
        demo1 = new RxJavaDemo1();
    }

    @Test
    public void rxJavaTest1() {
        demo1.rxJavaTest1();
    }

    @Test
    public void rxJavaTest2() {
        demo1.rxJavaTest2();
    }

    @Test
    public void rxJavaTest3() {
        demo1.rxJavaTest3();
    }
}