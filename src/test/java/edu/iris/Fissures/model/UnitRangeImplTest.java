package edu.iris.Fissures.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * QuantityTest.java
 *
 *
 * Created: Thu Feb 20 09:40:13 2003
 *
 * @author <a href="mailto:crotwell@maple.local.">Philip Crotwell</a>
 * @version 1.0
 */
public class UnitRangeImplTest  extends TestCase {
          
    public UnitRangeImplTest(String testname) {
        super(testname);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
        q = new UnitRangeImpl(-.005, .00000005, UnitImpl.MICROSECOND.inverse());
        tenMM = new UnitRangeImpl(-10, 10, UnitImpl.MILLIMETER);
        tenMM_per_Sec = new UnitRangeImpl(-10, 10, UnitImpl.MILLIMETER_PER_SECOND);
    }

    /**
     * Tears down the text fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
        q = null;
    }

    /**
     * Assembles and returns a test suite for
     * all the test methods of this test case.
     *
     * @return A non-null test suite.
     */
    public static Test suite() {

        //
        // Reflection is used here to add all
        // the testXXX() methods to the suite.
        //
        TestSuite suite = new TestSuite(UnitRangeImplTest.class);

        return suite;
    }

    public void testConvertTo() {
        UnitRangeImpl out = q.convertTo(UnitImpl.HERTZ);
        assertEquals(out.getMinValue(), q.getMinValue()*1000000, 0.001);
        
        out = tenMM.convertTo(UnitImpl.METER);
        assertEquals(out.getMinValue(), tenMM.getMinValue()/1000, 0.001);
        out = out.convertTo(UnitImpl.MILLIMETER);
        assertEquals(out.getMinValue(), tenMM.getMinValue(), 0.001);
        
        out = tenMM_per_Sec.convertTo(UnitImpl.METER_PER_SECOND);
        assertEquals(out.getMinValue(), tenMM_per_Sec.getMinValue()/1000, 0.001);
        out = out.convertTo(UnitImpl.MILLIMETER_PER_SECOND);
        assertEquals(out.getMinValue(), tenMM_per_Sec.getMinValue(), 0.001);
        
    }

    UnitRangeImpl q;
    
    UnitRangeImpl tenMM;
    
    UnitRangeImpl tenMM_per_Sec;
 
} // QuantityTest
