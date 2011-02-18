package edu.iris.Fissures.seismogramDC;

import edu.iris.Fissures.IfSeismogramDC.RequestFilter;
import edu.iris.Fissures.model.TimeUtils;
import edu.iris.Fissures.network.ChannelIdUtil;

/**
 * @author groves Created on Nov 2, 2004
 */
public class RequestFilterUtil {

    public static boolean areEqual(RequestFilter one, RequestFilter two) {
        if(one == two) { return true; }
        return ChannelIdUtil.areEqual(one.channel_id, two.channel_id)
                && TimeUtils.areEqual(one.start_time, two.start_time)
                && TimeUtils.areEqual(one.end_time, two.end_time);
    }

    public static String toString(RequestFilter rf) {
        return ChannelIdUtil.toStringNoDates(rf.channel_id) + " from "
                + rf.start_time.date_time + " to " + rf.end_time.date_time;
    }
}