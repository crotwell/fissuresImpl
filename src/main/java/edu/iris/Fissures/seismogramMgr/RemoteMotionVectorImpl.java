package edu.iris.Fissures.seismogramMgr;

import java.io.Serializable;

import edu.iris.Fissures.Sampling;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.Unit;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramDC.Property;
import edu.iris.Fissures.IfSeismogramMgr.RemoteMotionVector;
import edu.iris.Fissures.IfSeismogramMgr.Seismogram;
import edu.iris.Fissures.model.TimeInterval;

/**
 * RemoteMotionVectorImpl.java
 *
 *
 * Created: Thu Dec  6 22:17:09 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class RemoteMotionVectorImpl extends RemoteMotionVector {
    public RemoteMotionVectorImpl (){
	
    }

    /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static Serializable createEmpty() {
        return new RemoteMotionVectorImpl();
    }

    public RemoteMotionVectorImpl(String id,
                            Property[] properties,
                            Time begin_time,
                            int num_points,
                            Sampling sampling_info,
                            Unit y_unit,
                            ChannelId[] channel_group,
                            ParameterRef[] parm_ids,
                            TimeInterval[] time_corrections,
                            Sampling[] sample_rate_history,
                            Seismogram[] seismograms) {
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
        this.seismograms = seismograms;
    }



    public String get_id() {
        return id;
    }
 
}// RemoteMotionVectorImpl
