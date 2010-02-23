package edu.iris.Fissures.network;

import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfNetwork.SiteId;
import edu.iris.Fissures.model.TimeUtils;

/**
 * SiteIdUtil.java Created: Wed Jan 31 13:04:23 2001
 * 
 * @author Philip Crotwell
 * @version
 */
public class SiteIdUtil {

    public static boolean areEqual(SiteId a, SiteId b) {
        if(a == b) { return true; }
        return a.station_code.equals(b.station_code)
                && a.site_code.equals(b.site_code)
                && NetworkIdUtil.areEqual(a.network_id, b.network_id)
                && TimeUtils.areEqual(a.begin_time, b.begin_time);
    }

    public static String toString(SiteId id) {
        return NetworkIdUtil.toString(id.network_id) + NetworkIdUtil.DOT + id.station_code
                + NetworkIdUtil.DOT + id.site_code + NetworkIdUtil.DOT + id.begin_time.date_time;
    }

    public static String toStringFormatDates(SiteId id) {
        return NetworkIdUtil.toStringFormatDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code + NetworkIdUtil.DOT + id.site_code + NetworkIdUtil.DOT
                + TimeFormatter.format(id.begin_time);
    }

    public static String toStringNoDates(SiteId id) {
        return NetworkIdUtil.toStringNoDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code + NetworkIdUtil.DOT + id.site_code;
    }
    
    public static boolean areSameSite(ChannelId a, ChannelId b) {
        if(a == b) { return true; }
        return a.station_code.equals(b.station_code)
                && a.site_code.equals(b.site_code)
                && NetworkIdUtil.areEqual(a.network_id, b.network_id);
    }
} // SiteIdUtil
