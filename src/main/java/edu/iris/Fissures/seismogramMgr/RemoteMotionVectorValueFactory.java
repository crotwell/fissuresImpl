package edu.iris.Fissures.seismogramMgr;

/**
 * RemoteMotionVectorValueFactory.java
 *
 *
 * Created: Thu Dec  6 22:15:02 2001
 *
 * @author Philip Crotwell
 */

public class RemoteMotionVectorValueFactory implements org.omg.CORBA.portable.ValueFactory {

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = RemoteMotionVectorImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }

    
}// RemoteMotionVectorValueFactory
