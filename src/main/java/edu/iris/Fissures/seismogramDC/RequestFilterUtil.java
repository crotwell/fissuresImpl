package edu.iris.Fissures.seismogramDC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfSeismogramDC.RequestFilter;
import edu.iris.Fissures.model.MicroSecondDate;
import edu.iris.Fissures.model.TimeInterval;
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
    
    public static Map<String, List<RequestFilter>> splitByChannel(List<RequestFilter> rf) {
        HashMap<String, List<RequestFilter>> out = new HashMap<String, List<RequestFilter>>();
        for (RequestFilter requestFilter : rf) {
            String key = ChannelIdUtil.toStringNoDates(requestFilter.channel_id);
            if ( ! out.containsKey(key)) {
                out.put(key, new ArrayList<RequestFilter>());
            }
            out.get(key).add(requestFilter);
        }
        return out;
    }

    public static String toString(RequestFilter[] rf) {
        return toString(Arrays.asList(rf));
    }

    public static String toString(List<RequestFilter> rf) {
        String s = "";
        for (RequestFilter requestFilter : rf) {
            s += toString(requestFilter)+"\n";
        }
        return s;
    }
    
    public static String toString(RequestFilter rf) {
        return ChannelIdUtil.toStringNoDates(rf.channel_id) + " from "
                + rf.start_time.date_time + " to " + rf.end_time.date_time;
    }
    
    public static RequestFilter[] removeSmallRequests(RequestFilter[] rf, TimeInterval minSize) {
        List<RequestFilter> out = new ArrayList<RequestFilter>();
        for (int i = 0; i < rf.length; i++) {
           MicroSecondDate b = new MicroSecondDate(rf[i].start_time);
           MicroSecondDate e = new MicroSecondDate(rf[i].end_time);
           if (e.subtract(b).greaterThan(minSize)) {
               out.add(rf[i]);
           }
        }
        return out.toArray(new RequestFilter[0]);
    }
}