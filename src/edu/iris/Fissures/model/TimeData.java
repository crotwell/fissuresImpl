package edu.iris.Fissures.model;

/**
 * Interface for dealing with the different types of displayable data
 * in seismology, including seismograms, picks, predicted arrivals,
 * etc. Each of these will implement this interface which can be used when
 * they are displayed, etc.
 *
 *
 * Created: Tue Jul  6 14:42:24 1999
 *
 * @author Philip Crotwell
 * @version 
 */
public interface TimeData  {
    
    /** returns the earliest time for which this object "has data".
	For a seismogram, this is the time of the first data point,
	while for a pick it would be the time of the pick.  */
    public MicroSecondDate getBeginTime();
    
    /** returns the width in time for this object. For a seismogram,
     this would be the time from the first sample to the last sample,
     while for a pick, this would be 0 and whatever time unit is
     handy. 0 seconds would likely be the best choice.  */
    public TimeInterval getTimeInterval();

    /** returns the range of amplitudes for this object. For a
     seismogram, this would be the range of amplitudes in whatever
     units the seismogram is in. For things without amplitudes, for
     example picks, this would return null.  */
    public UnitRangeImpl getAmplitudeRange();

} // TimeData
