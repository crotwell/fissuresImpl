package edu.iris.Fissures.seismogramDC;

import edu.iris.Fissures.Sampling;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.Unit;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramDC.LocalMotionVector;
import edu.iris.Fissures.IfSeismogramDC.Property;
import edu.iris.Fissures.model.TimeInterval;

/**
 * MotionVectorAttrImpl.java
 *
 *
 * Created: Thu Dec  6 22:00:42 2001
 * The strange extends is to avoid diamond of death while still reusing this
 * class in LocalMotionVector.
 *
 * @author Philip Crotwell
 */

public class MotionVectorAttrImpl extends LocalMotionVector {

    protected MotionVectorAttrImpl() {
    }

    public MotionVectorAttrImpl(String id,
			    Property[] properties,
			    Time begin_time,
			    int num_points,
			    Sampling sampling_info,
			    Unit y_unit,
			    ChannelId[] channel_group,
			    ParameterRef[] parm_ids,
			    TimeInterval[] time_corrections,
			    Sampling[] sample_rate_history) {
	this.id = id;
	this.properties = properties;
	this.begin_time = begin_time;
	this.num_points = num_points;
	this.sampling_info = sampling_info;
	this.y_unit = y_unit;
	this.channel_group = channel_group;
	this.parm_ids = parm_ids;
	this.time_corrections = time_corrections;
	this.sample_rate_history = sample_rate_history;
    }

    /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static java.io.Serializable createEmpty() {
        return new MotionVectorAttrImpl();
    }

    public String get_id() {
	return id;
    }
    
}// MotionVectorAttrImpl
