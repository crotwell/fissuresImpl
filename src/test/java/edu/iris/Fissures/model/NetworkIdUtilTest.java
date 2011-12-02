package edu.iris.Fissures.model;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iris.Fissures.network.NetworkIdUtil;


public class NetworkIdUtilTest {

    @Test
    public void testTempNetId() {
        String[] tempCodes = new String[] { "XA", "YB", "ZC", "1A", "22", "34" };
        String[] permCodes = new String[] { "II", "G", "W7" };
        for (String netCode : tempCodes) {
            assertTrue(netCode, NetworkIdUtil.isTemporary(netCode));
        }
        for (String netCode : permCodes) {
            assertFalse(netCode, NetworkIdUtil.isTemporary(netCode));
        }
    }
}
