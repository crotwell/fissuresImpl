package edu.iris.Fissures.model;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "Fissures.idl"
 * <li> <b>IDL Name</b>      ::Fissures::UnitRange
 * <li> <b>Repository Id</b> IDL:edu.iris/Fissures/UnitRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * valuetype UnitRange  {
  ...
};
 * </pre>
 */
public class UnitRangeValueFactory implements org.omg.CORBA.portable.ValueFactory {
  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
    java.io.Serializable val = UnitRangeImpl.createEmpty();
    // create and initialize value
    val = is.read_value(val);
    return val;
  }
}
