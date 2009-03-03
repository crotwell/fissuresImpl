
package edu.iris.Fissures.seismogramDC;

import edu.iris.Fissures.model.RegisterVT;

/**
 * RegisterVTFactory.java
 *
 *
 * Created: Thu Dec 14 12:06:16 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class IfSeismogramDCRegisterVT extends RegisterVT {
    
    public IfSeismogramDCRegisterVT() {
	override(edu.iris.Fissures.IfSeismogramDC.SeismogramAttrHelper.id(),
		    new SeismogramAttrValueFactory());
	override(edu.iris.Fissures.IfSeismogramDC.LocalSeismogramHelper.id(),
		    new LocalSeismogramValueFactory());
    }
 
} // RegisterVTFactory
