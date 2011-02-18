package edu.iris.Fissures.network;

import java.util.StringTokenizer;

import edu.iris.Fissures.IfNetwork.Channel;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfNetwork.NetworkId;
import edu.iris.Fissures.model.ISOTime;
import edu.iris.Fissures.model.MicroSecondDate;
import edu.iris.Fissures.model.TimeUtils;

/**
 * ChannelIdUtil.java Created: Wed Jan 24 14:33:39 2001
 * 
 * @author Philip Crotwell
 * @version
 */
public class ChannelIdUtil {

    public static boolean areEqual(ChannelId a, ChannelId b) {
        return a.station_code.equals(b.station_code)
                && a.site_code.equals(b.site_code)
                && a.channel_code.equals(b.channel_code)
                && NetworkIdUtil.areEqual(a.network_id, b.network_id)
                && TimeUtils.areEqual(a.begin_time, b.begin_time);
    }
    
    public static boolean areEqualExceptForBeginTime(ChannelId a, ChannelId b) {
        return a.station_code.equals(b.station_code)
        && a.site_code.equals(b.site_code)
        && a.channel_code.equals(b.channel_code)
        && NetworkIdUtil.areEqual(a.network_id, b.network_id);
    }
    
    public static boolean areEqual(ChannelImpl a, ChannelImpl b) {
        return areEqual(a.getId(), b.getId()) &&
        a.getName() == b.getName() &&
        a.getOrientation().azimuth == b.getOrientation().azimuth &&
        a.getOrientation().dip == b.getOrientation().dip &&
        a.getSamplingInfo().numPoints == b.getSamplingInfo().numPoints &&
        a.getSamplingInfo().interval.the_units.equals(b.getSamplingInfo().interval.the_units) &&
        a.getSamplingInfo().interval.value == b.getSamplingInfo().interval.value;
    }

    public static String toStringNoDates(ChannelId id) {
        return NetworkIdUtil.toStringNoDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code + NetworkIdUtil.DOT + id.site_code + NetworkIdUtil.DOT + id.channel_code;
    }

    public static String toStringNoDates(Channel chan) {
        return toStringNoDates(chan.get_id());
    }

    public static String toString(ChannelId id) {
        return NetworkIdUtil.toString(id.network_id)
                + NetworkIdUtil.DOT
                + id.station_code
                + NetworkIdUtil.DOT
                + id.site_code
                + NetworkIdUtil.DOT
                + id.channel_code
                + NetworkIdUtil.DOT
                + new MicroSecondDate(id.begin_time).getFissuresTime().date_time;
    }

    public static ChannelId fromString(String s) {
        NetworkId netId = NetworkIdUtil.fromString(s);
        StringTokenizer st = NetworkIdUtil.getTokenizerAfterNetworkId(s);
        return new ChannelId(netId,
                             st.nextToken(),
                             st.nextToken(),
                             st.nextToken(),
                             new ISOTime(st.nextToken()).getDate()
                                     .getFissuresTime());
    }

    public static String toStringFormatDates(ChannelId id) {
        return NetworkIdUtil.toStringFormatDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code + NetworkIdUtil.DOT + id.site_code + NetworkIdUtil.DOT + id.channel_code
                + NetworkIdUtil.DOT + TimeFormatter.format(id.begin_time);
    }

    public static int hashCode(ChannelId id) {
        return 12 + toString(id).hashCode();
    }
} // ChannelIdUtil
