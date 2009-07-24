package edu.iris.Fissures.dataSetMgr;

/**
 * LocalDataSetValueFactory.java
 *
 *
 * Created: Thu Dec  6 17:26:12 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class LocalDataSetValueFactory implements org.omg.CORBA.portable.ValueFactory{

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = LocalDataSetImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }
}// LocalDataSetValueFactory
