
package edu.iris.Fissures.model;

import junitx.extensions.EqualsHashCodeTestCase;
import edu.iris.Fissures.UnitBase;

public class UnitImplTest  extends EqualsHashCodeTestCase {

    protected Object createInstance() throws Exception {
        return  new UnitImpl(UnitBase.GRAM, 1, 0);
    }

    protected Object createNotEqualInstance() throws Exception {
        return new UnitImpl(UnitBase.GRAM, 1, 3);
    }

    public UnitImplTest(String testname) { super(testname); }

    public void testGetTotalPower() {
        assertEquals(UnitImpl.KILOMETER.getTotalPower(), 3);
        UnitImpl perKiloMeter = UnitImpl.KILOMETER.inverse();
        assertEquals(perKiloMeter.getTotalPower(), -3);
    }

    public void tenthMilliTest() {
        QuantityImpl q = new QuantityImpl(1, UnitImpl.MILLISECOND);
        q = q.convertTo(UnitImpl.TENTHMILLISECOND);
        assertEquals((int)q.get_value(), 10);
    }
    
    public void testIsConvertibleTo() {
        assertTrue(UnitImpl.SECOND.isConvertableTo(UnitImpl.SECOND));
        assertTrue(UnitImpl.HOUR.isConvertableTo(UnitImpl.SECOND));
        assertTrue(UnitImpl.KILOMETER.isConvertableTo(UnitImpl.METER));
        assertTrue(UnitImpl.multiply(UnitImpl.KILOMETER_PER_SECOND, UnitImpl.DAY).isConvertableTo(UnitImpl.METER));
    }
}
