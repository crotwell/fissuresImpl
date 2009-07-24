
package edu.iris.Fissures.event;

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

public class IfEventRegisterVT extends RegisterVT {
    
    public IfEventRegisterVT() {
	override(edu.iris.Fissures.IfEvent.EventAttrHelper.id(),
		    new EventAttrValueFactory());
	override(edu.iris.Fissures.IfEvent.OriginHelper.id(),
		    new OriginValueFactory());
	override(edu.iris.Fissures.IfEvent.PredictedArrivalHelper.id(),
		    new PredictedArrivalValueFactory());
    }
 
} // RegisterVTFactory
