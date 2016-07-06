package edu.iris.Fissures.dataSetMgr;

import edu.iris.Fissures.IfDataSetMgr.SeismogramNode;
import edu.iris.Fissures.IfSeismogramMgr.SeismogramAccess;

/**
 * SeismogramNodeImpl.java
 *
 *
 * Created: Thu Dec  6 20:18:04 2001
 *
 * @author Philip Crotwell
 * @version
 */

public class SeismogramNodeImpl extends SeismogramNode {
    protected SeismogramNodeImpl (){
    }

        /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static java.io.Serializable createEmpty() {
        return new LocalDataSetImpl();
    }

    public SeismogramNodeImpl(SeismogramAccess seismogram,
			      String id) {

    }

    public String get_id() {
	return id;
    }

}// SeismogramNodeImpl
