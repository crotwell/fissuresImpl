package edu.iris.Fissures.seismogramDC;


/**
 * LocalMotionVectorValueFactory.java
 *
 *
 * Created: Thu Dec  6 21:18:59 2001
 *
 * @author Philip Crotwell
 */

public class LocalMotionVectorValueFactory  implements org.omg.CORBA.portable.ValueFactory {

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = 
	    LocalMotionVectorImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }
}// LocalMotionVectorValueFactory
