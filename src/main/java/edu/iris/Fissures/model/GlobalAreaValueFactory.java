package edu.iris.Fissures.model;


/**
 * GlobalAreaValueFactory.java
 *
 *
 * Created: Thu Dec  6 20:12:13 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class GlobalAreaValueFactory  implements org.omg.CORBA.portable.ValueFactory{

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = 
	    GlobalAreaImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }

}// GlobalAreaValueFactory
