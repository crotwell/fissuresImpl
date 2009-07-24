
package edu.iris.Fissures.seismogramMgr;

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

public class IfSeismogramMgrRegisterVT extends RegisterVT {
    
    public IfSeismogramMgrRegisterVT() {
	override(edu.iris.Fissures.IfSeismogramMgr.RemoteMotionVectorHelper.id(),
		    new RemoteMotionVectorValueFactory());
    }
 
} // RegisterVTFactory
