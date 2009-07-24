package edu.iris.Fissures.model;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "Fissures.idl"
 * <li> <b>IDL Name</b>      ::Fissures::Quantity
 * <li> <b>Repository Id</b> IDL:edu.iris/Fissures/Quantity:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * valuetype Quantity  {
  ...
};
 * </pre>
 */
public class QuantityValueFactory implements org.omg.CORBA.portable.ValueFactory {
  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is) {
    java.io.Serializable val = QuantityImpl.createEmpty();
    // create and initialize value
    val = is.read_value(val);
    QuantityImpl q = (QuantityImpl)val;
    UnitImpl unit = q.getUnit();
    if (unit.isConvertableTo(UnitImpl.SECOND)) {
        val = new TimeInterval(q.getValue(),
                               unit);
    }
    return val;
  }
}
