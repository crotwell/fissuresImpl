package edu.iris.Fissures.network;

import edu.iris.Fissures.IfNetwork.Station;
import edu.iris.Fissures.IfNetwork.StationId;
import edu.iris.Fissures.model.TimeUtils;

/**
 * StationIdUtil.java Created: Wed Jan 31 13:06:03 2001
 * 
 * @author Philip Crotwell
 * @version
 */
public class StationIdUtil {

    public static boolean areEqual(StationId a, StationId b) {
        if(a == b) {
            return true;
        }
        return a.station_code.equals(b.station_code)
                && NetworkIdUtil.areEqual(a.network_id, b.network_id)
                && TimeUtils.areEqual(a.begin_time, b.begin_time);
    }

    public static String toString(Station sta) {
        return toString(sta.get_id());
    }

    public static String toString(StationId id) {
        return NetworkIdUtil.toString(id.network_id) + NetworkIdUtil.DOT + id.station_code
                + NetworkIdUtil.DOT + id.begin_time.date_time;
    }

    public static String toStringFormatDates(Station sta) {
        return toStringFormatDates(sta.get_id());
    }

    public static String toStringFormatDates(StationId id) {
        return NetworkIdUtil.toStringFormatDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code + NetworkIdUtil.DOT + TimeFormatter.format(id.begin_time);
    }

    public static String toStringNoDates(Station sta) {
        return toStringNoDates(sta.get_id());
    }

    public static String toStringNoDates(StationId id) {
        return NetworkIdUtil.toStringNoDates(id.network_id) + NetworkIdUtil.DOT
                + id.station_code;
    }

    public static boolean areEqual(Station a, Station b) {
        return areEqual(a.get_id(), b.get_id());
    }
} // StationIdUtil
