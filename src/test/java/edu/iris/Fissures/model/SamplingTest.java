package edu.iris.Fissures.model;

import junitx.extensions.EqualsHashCodeTestCase;
public class SamplingTest  extends EqualsHashCodeTestCase {
    public SamplingTest(String testname) { super(testname); }
    
    protected void setUp() {
        sampling = (SamplingImpl)createInstance();
        try {   super.setUp();} catch (Exception e) {}
    }

    public void testGetFrequency() {
        QuantityImpl freq = sampling.getFrequency();
        assertTrue(freq.getUnit().isConvertableTo(UnitImpl.HERTZ));
    }
    
    protected Object createInstance(){
        return new SamplingImpl(20, new TimeInterval(1, UnitImpl.SECOND));
    }
    
    protected Object createNotEqualInstance(){
        return new SamplingImpl(30, new TimeInterval(1, UnitImpl.SECOND));
    }

    SamplingImpl sampling;
} // TimestampDBTest
