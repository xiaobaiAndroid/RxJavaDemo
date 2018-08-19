package com.bzf.rxjavademo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectTest {

    private Subject subject;

    @Before
    public void setUp() throws Exception {
        subject = new Subject();
    }

    @Test
    public void test1() {
        subject.test1();
    }
}