package edu.iris.Fissures.model;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "Fissures.idl"
 * <li> <b>IDL Name</b>      ::Fissures::Sampling
 * <li> <b>Repository Id</b> IDL:edu.iris/Fissures/Sampling:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * valuetype Sampling  {
 ...
 };
 * </pre>
 */
public class SamplingValueFactory implements org.omg.CORBA.portable.ValueFactory {
    public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
        java.io.Serializable val = SamplingImpl.createEmpty();
        // create and initialize value
        val = is.read_value(val);
        // make sure interval is a TimeInterval instead of just a QuantityImpl
        ((SamplingImpl)val).interval = TimeInterval.createTimeInterval(((SamplingImpl)val).interval);
        return val;
    }
}
