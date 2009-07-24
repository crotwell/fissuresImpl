package edu.iris.Fissures.network;

import java.util.StringTokenizer;
import java.util.regex.Pattern;
import edu.iris.Fissures.IfNetwork.NetworkAttr;
import edu.iris.Fissures.IfNetwork.NetworkId;
import edu.iris.Fissures.model.ISOTime;
import edu.iris.Fissures.model.MicroSecondDate;
import edu.iris.Fissures.model.TimeUtils;

/**
 * NetworkIdUtil.java Created: Wed Jan 31 13:07:45 2001
 * 
 * @author Philip Crotwell
 * @version
 */
public class NetworkIdUtil {

    public static boolean isTemporary(NetworkId id) {
        return isTemporary(id.network_code);
    }

    public static boolean isTemporary(String code) {
        return tempNetPattern.matcher(code).matches();
    }

    private static Pattern tempNetPattern = Pattern.compile("[XYZ].?");

    /**
     * Compares two networkIds. Dates are only checked for temporary networks.
     */
    public static boolean areEqual(NetworkId a, NetworkId b) {
        if(!a.network_code.equals(b.network_code)) {
            return false;
        }
        // only compare dates if temp network, ie network code starts with X, Y,
        // Z
        return !isTemporary(a)
                || TimeUtils.areEqual(a.begin_time, b.begin_time);
    }

    public static String toString(NetworkAttr net) {
        return toString(net.get_id());
    }

    public static String toString(NetworkId id) {
        return id.network_code
                + "."
                + new MicroSecondDate(id.begin_time).getFissuresTime().date_time;
    }

    public static NetworkId fromString(String s) {
        StringTokenizer st = new StringTokenizer(s, ".");
        return new NetworkId(st.nextToken(),
                             new ISOTime(st.nextToken()).getDate()
                                     .getFissuresTime());
    }

    public static StringTokenizer getTokenizerAfterNetworkId(String s) {
        StringTokenizer st = new StringTokenizer(s, ".");
        st.nextToken();
        st.nextToken();
        return st;
    }

    public static String toStringFormatDates(NetworkAttr net) {
        return toStringFormatDates(net.get_id());
    }

    public static String toStringFormatDates(NetworkId id) {
        return id.network_code + "." + TimeFormatter.format(id.begin_time);
    }

    public static String toStringNoDates(NetworkAttr net) {
        return toStringNoDates(net.get_id());
    }

    public static String toStringNoDates(NetworkId id) {
        // passcal networks need year
        if(id.network_code.startsWith("X") || id.network_code.startsWith("Y")
                || id.network_code.startsWith("Z")) {
            return id.network_code + getTwoCharYear(id);
        }
        return id.network_code;
    }

    public static String getTwoCharYear(NetworkId id) {
        return id.begin_time.date_time.substring(2, 4);
    }

    public static int hashCode(NetworkId id) {
        return 57 + toString(id).hashCode();
    }
} // NetworkIdUtil
