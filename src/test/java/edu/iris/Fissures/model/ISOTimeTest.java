package edu.iris.Fissures.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class ISOTimeTest {

    @Test
    public void test60ISOTimeString() {
        ISOTime iso = new ISOTime("2012102J235960.000Z");
        assertTrue(true);
    }
    @Test
    public void testISOTimeString() {
        ISOTime iso = new ISOTime("2012102J235959.000Z");
        assertTrue(true);
    }
    @Test
    public void testISOTimeString2() {
        ISOTime iso = new ISOTime("2012102J235959.000Z");
        assertTrue(true);
    }
}
