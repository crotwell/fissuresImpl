package edu.iris.Fissures.model;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "Fissures.idl"
 * <li> <b>IDL Name</b>      ::Fissures::Unit
 * <li> <b>Repository Id</b> IDL:edu.iris/Fissures/Unit:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * valuetype Unit  {
  ...
};
 * </pre>
 */
public class UnitValueFactory implements org.omg.CORBA.portable.ValueFactory {
  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
    java.io.Serializable val = UnitImpl.createEmpty();
    // create and initialize value
    val = is.read_value(val);
    return val;
  }
}
