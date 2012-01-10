package edu.iris.Fissures.dataSetMgr;

/**
 * MotionVectorNodeValueFactory.java
 *
 *
 * Created: Thu Dec  6 19:08:43 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class MotionVectorNodeValueFactory  implements org.omg.CORBA.portable.ValueFactory {

    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
	java.io.Serializable val = edu.iris.Fissures.dataSetMgr.MotionVectorNodeImpl.createEmpty();
	// create and initialize value
	return is.read_value(val);
    }
    
}// MotionVectorNodeValueFactory
