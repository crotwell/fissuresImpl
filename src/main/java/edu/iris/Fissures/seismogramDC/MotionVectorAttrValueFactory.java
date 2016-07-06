package edu.iris.Fissures.seismogramDC;


/**
 * MotionVectorAttrValueFactory.java
 *
 *
 * Created: Thu Dec  6 21:58:10 2001
 *
 * @author Philip Crotwell
 */

public class MotionVectorAttrValueFactory  implements org.omg.CORBA.portable.ValueFactory {

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = 
	    edu.iris.Fissures.seismogramDC.MotionVectorAttrImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }
}// MotionVectorAttrValueFactory
