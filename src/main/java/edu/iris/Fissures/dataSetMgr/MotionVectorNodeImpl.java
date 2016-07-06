package edu.iris.Fissures.dataSetMgr;

import edu.iris.Fissures.IfDataSetMgr.MotionVectorNode;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramMgr.Seismogram;

/**
 * MotionVectorNodeImpl.java
 *
 *
 * Created: Thu Dec  6 19:10:19 2001
 *
 * @author Philip Crotwell
 * @version
 */

public class MotionVectorNodeImpl extends MotionVectorNode {
    protected MotionVectorNodeImpl (){
	
    }
    

    /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static java.io.Serializable createEmpty() {
        return new LocalDataSetImpl();
    }

    public MotionVectorNodeImpl(String id, 
			    Seismogram[] seismograms, 
			    ParameterRef[] parm_ids) {
	this.id = id;
	this.seismograms = seismograms;
	this.parm_ids = parm_ids;
    }

    public String get_id() {
	return id;
    }
}// MotionVectorNodeImpl
