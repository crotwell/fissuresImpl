package edu.iris.Fissures.model;

import junitx.extensions.EqualsHashCodeTestCase;
import edu.iris.Fissures.Unit;
import edu.iris.Fissures.UnitBase;

public class QuantityTest extends EqualsHashCodeTestCase {

    public QuantityTest(String testname) {
        super(testname);
    }

    protected void setUp() {
        try {
            super.setUp();
        } catch(Exception e) {}
        q = (QuantityImpl)createInstance();
        tenMM = (QuantityImpl)createNotEqualInstance();
        tenMM_per_Sec = new QuantityImpl(10, UnitImpl.MILLIMETER_PER_SECOND);
    }

    public void testConvertTo() {
        QuantityImpl out = q.convertTo(UnitImpl.HERTZ);
        assertEquals(out.value, q.value * 1000000, 0.001);
        out = tenMM.convertTo(UnitImpl.METER);
        assertEquals(out.value, tenMM.getValue() / 1000, 0.001);
        out = out.convertTo(UnitImpl.MILLIMETER);
        assertEquals(out.value, tenMM.getValue(), 0.001);
        out = tenMM_per_Sec.convertTo(UnitImpl.METER_PER_SECOND);
        assertEquals(out.value, tenMM_per_Sec.getValue() / 1000, 0.001);
        out = out.convertTo(UnitImpl.MILLIMETER_PER_SECOND);
        assertEquals(out.value, tenMM_per_Sec.getValue(), 0.001);
    }

    public void testInverse() {
        QuantityImpl out = q.inverse().inverse();
        assertEquals(out.value, q.value, 0.00001);
    }

    public void testConvertEquals() {
        UnitImpl fakeKM = new UnitImpl(UnitBase.METER, 1, 3);
        QuantityImpl one = new QuantityImpl(378.0, UnitImpl.KILOMETER);
        QuantityImpl two;
        two = new QuantityImpl(378.0, UnitImpl.KILOMETER);
        assertTrue("equals with unit object equals", one.equals(two));
        two = new QuantityImpl(378.0, fakeKM);
        assertTrue("equals with non-object equals", one.equals(two));
        Unit[] sub = new Unit[1];
        sub[0] = fakeKM;
        two = new QuantityImpl(378.0, new UnitImpl(sub, 0, "", 1, 1));
        assertTrue("equals with array subunit " + two, one.equals(two));
    }

    public void testTemperature() {
        QuantityImpl zeroK = new QuantityImpl(0, UnitImpl.KELVIN);
        QuantityImpl zeroC = new QuantityImpl(0, UnitImpl.CELSIUS);
        QuantityImpl zeroF = new QuantityImpl(0, UnitImpl.FAHRENHEIT);
        QuantityImpl out;
        assertEquals(-273.15, zeroK.getValue(UnitImpl.CELSIUS), 0.000000001);
        assertEquals(-459.67, zeroK.getValue(UnitImpl.FAHRENHEIT), 0.000000001);
        assertEquals(273.15, zeroC.getValue(UnitImpl.KELVIN), 0.000000001);
        assertEquals(0, zeroC.getValue(UnitImpl.CELSIUS), 0.000000001);
        assertEquals(32, zeroC.getValue(UnitImpl.FAHRENHEIT), 0.000000001);
        assertEquals(-17.7777777778, zeroF.getValue(UnitImpl.CELSIUS), 0.0000001);
        assertEquals(255.37, zeroF.getValue(UnitImpl.KELVIN), 0.01);
    }
    
    public void convertDayToMicroSecTest() {
        QuantityImpl q = new QuantityImpl(1, UnitImpl.DAY);
        q = q.convertTo(UnitImpl.MICROSECOND);
        assertEquals((int)q.get_value(), 86400*1000*1000);
    }
    
    protected Object createInstance() {
        return new QuantityImpl(.00000005, UnitImpl.MICROSECOND.inverse());
    }

    protected Object createNotEqualInstance() {
        return new QuantityImpl(10, UnitImpl.MILLIMETER);
    }

    QuantityImpl q;

    QuantityImpl tenMM;

    QuantityImpl tenMM_per_Sec;
} // QuantityTest
