package edu.iris.Fissures.seismogramDC;

import edu.iris.Fissures.Sampling;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.Unit;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramDC.Property;
import edu.iris.Fissures.IfSeismogramDC.VectorComponent;
import edu.iris.Fissures.model.TimeInterval;

/**
 * LocalMotionVectorImpl.java
 *
 *
 * Created: Thu Dec  6 21:20:33 2001
 *
 * @author Philip Crotwell
 */

public class LocalMotionVectorImpl extends MotionVectorAttrImpl {
    protected LocalMotionVectorImpl (){
	
    }

    public LocalMotionVectorImpl(String id,
				 Property[] properties,
				 Time begin_time,
				 int num_points,
				 Sampling sampling_info,
				 Unit y_unit,
				 ChannelId[] channel_group,
				 ParameterRef[] parm_ids,
				 TimeInterval[] time_corrections,
				 Sampling[] sample_rate_history,
				 VectorComponent[] data) {
	super(id,
	      properties,
	      begin_time,
	      num_points,
	      sampling_info,
	      y_unit,
	      channel_group,
	      parm_ids,
	      time_corrections,
	      sample_rate_history);
	this.data = data;
    }

    /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static java.io.Serializable createEmpty() {
        return new LocalMotionVectorImpl();
    }

    public String get_id() {
	return id;
    }

}// LocalMotionVectorImpl
