package edu.iris.Fissures.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class ISOTimeTest {

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

    @Test
    public void testGetMicros() {
        ISOTime iso = new ISOTime("2012102J235959.123Z");
        assertEquals("000", iso.getMicroseconds());
        iso = new ISOTime("2012102J235959.1234Z");
        assertEquals("400", iso.getMicroseconds());
        iso = new ISOTime("2012102J235959.12345Z");
        assertEquals("450", iso.getMicroseconds());
        iso = new ISOTime("2012102J235959.123456Z");
        assertEquals("456", iso.getMicroseconds());
    }

    @Test
    public void testMSDRoundTrip() {
        String s = "20120301T23:59:59.";
        NumberFormat f = new DecimalFormat("0000");
        for (int i = 0; i < 10000; i++) {
            String micros = f.format(i);
            if (i%10 == 0) {
                // skip 0 as we don't add 4th digit if zero
                micros = micros.substring(0, 3);
            }
            String testS = s + micros + "Z";
            MicroSecondDate d = new MicroSecondDate(testS);
            assertEquals(i%10, d.getMicroSeconds()/100);
            assertEquals(testS, d.getFissuresTime().date_time);
        }
        assertTrue(true);
    }
}
