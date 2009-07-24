
package edu.iris.Fissures.model;

/**
 * LeapSecondHistory.java
 * Records leapseconds so that time differences may be converted properly.
 * The data is from 
 * <a href="ftp://maia.usno.navy.mil/ser7/tai-utc.dat">tai-utc.dat</a>.<BREAK>
 * and more info can be found at
 * <a href="http://maia.usno.navy.mil/>maia.usno.navy.mil</a>
 *
 *
 * Created: Fri Oct  1 12:04:08 1999
 *
 * @author Philip Crotwell
 * @version
 */

public class LeapSecondHistory  {

    public static LeapSecondHistory getLeapSecondHistory() {
        return singleton;
    }

    
    
    /** use singleton pattern. */
    private LeapSecondHistory() {
        leaps = new LeapSecond[22];
    }

    private static LeapSecondHistory singleton = new LeapSecondHistory();

    protected static LeapSecond[] leaps;
    
} // LeapSecondHistory
