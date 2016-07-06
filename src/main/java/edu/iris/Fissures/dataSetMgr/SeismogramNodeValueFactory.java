package edu.iris.Fissures.dataSetMgr;

/**
 * SeismogramNodeValueFactory.java
 *
 *
 * Created: Thu Dec  6 20:24:20 2001
 *
 * @author Philip Crotwell
 * @version
 */

public class SeismogramNodeValueFactory  implements org.omg.CORBA.portable.ValueFactory {

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = 
	    edu.iris.Fissures.dataSetMgr.SeismogramNodeImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }

}// SeismogramNodeValueFactory
