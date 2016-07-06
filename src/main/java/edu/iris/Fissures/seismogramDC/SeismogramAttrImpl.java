
package edu.iris.Fissures.seismogramDC;

import java.io.Serializable;

import edu.iris.Fissures.AuditElement;
import edu.iris.Fissures.NotImplemented;
import edu.iris.Fissures.Quantity;
import edu.iris.Fissures.Sampling;
import edu.iris.Fissures.Time;
import edu.iris.Fissures.Unit;
import edu.iris.Fissures.IfNetwork.ChannelId;
import edu.iris.Fissures.IfParameterMgr.ParameterRef;
import edu.iris.Fissures.IfSeismogramDC.LocalSeismogram;
import edu.iris.Fissures.IfSeismogramDC.Property;
import edu.iris.Fissures.IfTimeSeries.EncodedData;
import edu.iris.Fissures.IfTimeSeries.SequenceOutOfOrder;
import edu.iris.Fissures.model.ISOTime;
import edu.iris.Fissures.model.MicroSecondDate;
import edu.iris.Fissures.model.QuantityImpl;
import edu.iris.Fissures.model.SamplingImpl;
import edu.iris.Fissures.model.TimeInterval;
import edu.iris.Fissures.model.UnitImpl;
import edu.iris.Fissures.model.UnsupportedFormat;

/**
 * Implementation of the SeismogramAttr abstract class that is generated from
 * the IDL compiler. This holds the metadata for a seismogram, ie everything
 * except the actual timeseries data points.
 *
 *
 * Created: Wed Feb 23 12:51:21 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class SeismogramAttrImpl extends LocalSeismogram {
    // extends SeismogramAttr {
    // hack to avoid diamond of death, LocalSeismogram extends
    // SeismogramAttr, which is what we need


    /** A protected constructor that creates an empty SeismogramAttrImpl
     *  instance. This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    protected SeismogramAttrImpl() {

    }

    /** A factory method to create an empty SeismogramAttrImpl.
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static Serializable createEmpty() {
        return new SeismogramAttrImpl();
    }

    public SeismogramAttrImpl(String id,
                              Time begin_time,
                              int num_points,
                              Sampling sample_info,
                              Unit y_unit,
                              ChannelId channel_id) {
        this(id, new Property[0], begin_time, num_points, sample_info, y_unit, channel_id, new ParameterRef[0], new Quantity[0], new Sampling[0]);
    }
    
    /** creates a new SeismogramAttrImpl.
     *
     * @param id The internal id for the seismogram. This is for the internal
     * use of the persistant storage system and should be unique within that
     * system.
     *
     * @param properties Properties for the seismogram, perhaps including a
     *     "Name" property for labeling a display.
     *
     * @param begin_time that time of the first sample in the seismogram.
     *
     * @param num_points The number of sample points.
     *
     * @param sample_info The frequency of sampling.
     *
     * @param y_unit The amplitude units of the seismogram.
     *
     * @param channel_id The id of the channel that recorded the seismogram.
     *
     * @param time_corrections The time corrections that
     *            have been applied to the begin time. Must be of type
     *            time intervals (ie convertable to seconds) even though
     *            the signature is Quantity.
     */
    public SeismogramAttrImpl(String id,
                              Property[] properties,
                              Time begin_time,
                              int num_points,
                              Sampling sample_info,
                              Unit y_unit,
                              ChannelId channel_id,
                  ParameterRef[] parm_ids,
                              edu.iris.Fissures.Quantity[] time_corrections,
                  Sampling[] sample_rate_history) {
        this.id = id;
        this.begin_time = begin_time;
        this.num_points = num_points;
        this.sampling_info = sample_info;
        this.y_unit = y_unit;
        this.channel_id = channel_id;
        this.time_corrections = time_corrections;
        this.sample_rate_history = sample_rate_history;
        setProperties(properties);
    setParameterRefs(parm_ids);
    }

    /** @return the id of this seismogram. Should be unique.
     */
    public String get_id() {
        return id;
    }

    /** @return the number of data points within the seismogram.
     */
    public int getNumPoints() {
        return num_points;
    }

    public void setProperties(Property[] props) {
        if (props==null) {
            throw new IllegalArgumentException("Cannot set null properties.");
        }
        this.properties = props;
    }

    public Property[] getProperties() {
        return properties;
    }

    public String getProperty(String name) {
    for (int i=0; i<properties.length; i++) {
        if (properties[i].name.equals(name)) {
        return properties[i].value;
        } // end of if (properties[i].name.equals(name))
    } // end of for (int i=0; i<properties.length; i++)
    return null;
    }


    public void setProperty(String name, String value) {

    for(int i = 0; i < properties.length; i++) {
        if(properties[i].name.equals(name)) {
            properties[i].value = value;
            return;
        }
    }
    Property[] props  = new Property[this.properties.length + 1];
    System.arraycopy(this.properties, 0, props, 0, this.properties.length);
    props[this.properties.length].name = name;
    props[this.properties.length].value = value;
    setProperties(props);
    }

    public void setParameterRefs(ParameterRef[] parm_ids) {
    this.parm_ids = parm_ids;
    }

    public ParameterRef[] getParameterRefs() {
    return parm_ids;
    }

    /**
       Gets the time of the first sample.

       @return the time of the first sample as a MicroSecondDate.

       @throws UnsupportedFormat if the time string is not recognized.
    */
    public MicroSecondDate getBeginTime() throws UnsupportedFormat {
    if (beginTime == null) {
        ISOTime t =
        new ISOTime(begin_time.date_time);
        beginTime = t.getDate();
    }
    return beginTime;
    }

    /**@return the amount of time that this seismogram covers.
     */
    public TimeInterval getTimeInterval() {
    QuantityImpl q = getSampling().getPeriod();

    return new TimeInterval(q.getValue() *
                                (num_points -1),
                                q.getUnit());
    }


    /**
       @return the time of the last sample of this seismogram.
    */
    public MicroSecondDate getEndTime() {
    return getBeginTime().add(getTimeInterval());
    }

    /**
    @return the name given to this seismogram.
    */
    public String getName() {
        if (properties == null) return get_id();
        for (int i=0; i<properties.length; i++) {
            if (properties[i].name.equals("Name")) {
                return properties[i].value;
            }
        }
        return get_id();
    }

    /** Sets a name, for human readablilty. */
    public void setName(String name) {
        int nameNum = -1;
        if (properties == null || properties.length == 0) {
            this.properties = new Property[1];
            nameNum = 0;
        } else {
            for (int i=0; i<properties.length; i++) {
                if (properties[i].name.equals("Name")) {
                    nameNum = i;
                    break;
                }
            }
            // must not be there yet
        if(nameNum == -1) {
                Property[] tmp = new Property[properties.length+1];
                System.arraycopy(properties, 0, tmp, 0, properties.length);
                nameNum = properties.length-1;
                properties = tmp;
         }
        }
        properties[nameNum] = new Property("Name", name);
    }

    /** @return the units of amplitude of the timeseries.
     */
    public UnitImpl getUnit() {
        //cast to edu.iris.Fissures.model.Unit
    return (UnitImpl)y_unit;
    }

    /** @return the id of the channel that the seismogram was recorded from.
     */
    public ChannelId getChannelID() {
    return channel_id;
    }

    /** @return the samapling information for the seismogram. Note that this
    may be different from the nominal sampling rate of the channel if a
    sampling ajusting time correction has been applied.
    */
    public SamplingImpl getSampling() {
        //cast to edu.iris.Fissures.model.Sampling
    return (SamplingImpl)sampling_info;
    }

    /** Cache for the begintime of the seismogram. Just to avoid reparsing the
    ISO time string.
    */
    protected MicroSecondDate beginTime;


    /* The below methods are no-ops due to the hack to make implementation
       inheritence work, ie avoiding diamond of death. */

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_closed:1.0
    //
    /***/

    public boolean
    is_closed() {
    throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram");
    }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_long:1.0
    //
    /***/

    public boolean
    is_long() {
    throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram");
    }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_float:1.0
    //
    /***/

    public boolean
    is_float() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_double:1.0
    //
    /***/

    public boolean
    is_double() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_short:1.0
    //
    /***/

    public boolean
    is_short() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/is_encoded:1.0
    //
    /***/

    public boolean
    is_encoded() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/can_convert_to_long:1.0
    //
    /***/

    public boolean
    can_convert_to_long() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/can_convert_to_float:1.0
    //
    /***/

    public boolean
    can_convert_to_float() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/can_convert_to_double:1.0
    //
    /***/

    public boolean
    can_convert_to_double() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/can_convert_to_short:1.0
    //
    /***/

    public boolean
    can_convert_to_short() { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/get_as_longs:1.0
    //
    /***/

    public int[]
    get_as_longs()
        throws edu.iris.Fissures.FissuresException { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/get_as_shorts:1.0
    //
    /***/

    public short[]
    get_as_shorts()
        throws edu.iris.Fissures.FissuresException { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/get_as_floats:1.0
    //
    /***/

    public float[]
    get_as_floats()
        throws edu.iris.Fissures.FissuresException { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/get_as_doubles:1.0
    //
    /***/

    public double[]
    get_as_doubles()
        throws edu.iris.Fissures.FissuresException { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAccess/get_as_encoded:1.0
    //
    /***/

    public EncodedData[]
    get_as_encoded()
        throws edu.iris.Fissures.FissuresException { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/close:1.0
    //
    /***/

    public void
    close() {
    throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram");
    }

    //
    // IDL:iris.edu/Fissures/AuditSystemAccess/get_audit_trail:1.0
    //
    /***/

    public AuditElement[]
    get_audit_trail()
        throws NotImplemented {
    throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram");
    }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_longs:1.0
    //
    /***/

    public void
    append_longs(int seq_num,
                 int[] data,
                 edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_shorts:1.0
    //
    /***/

    public void
    append_shorts(int seq_num,
                  short[] data,
                  edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_floats:1.0
    //
    /***/

    public void
    append_floats(int seq_num,
                  float[] data,
                  edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_doubles:1.0
    //
    /***/

    public void
    append_doubles(int seq_num,
                   double[] data,
                   edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_encoded_seq:1.0
    //
    /***/

    public void
    append_encoded_seq(int seq_num,
                       EncodedData[] data,
                       edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

    //
    // IDL:iris.edu/Fissures/IfTimeSeries/TimeSeriesAdmin/append_encoded:1.0
    //
    /***/

    public void
    append_encoded(int seq_num,
                   EncodedData data,
                   edu.iris.Fissures.AuditInfo[] audit_info)
        throws SequenceOutOfOrder { throw new org.omg.CORBA.NO_IMPLEMENT("not a LocalSeismogram"); }

} // SeismogramAttrImpl
