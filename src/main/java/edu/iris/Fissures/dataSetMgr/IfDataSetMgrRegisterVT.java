package edu.iris.Fissures.dataSetMgr;

import edu.iris.Fissures.model.RegisterVT;

/**
 * IfDataSetMgrRegisterVT.java
 *
 *
 * Created: Thu Dec  6 17:28:54 2001
 *
 * @author Philip Crotwell
 * @version
 */

public class IfDataSetMgrRegisterVT extends RegisterVT {
     
   public IfDataSetMgrRegisterVT() {
	override(edu.iris.Fissures.IfDataSetMgr.LocalDataSetHelper.id(),
		    new LocalDataSetValueFactory());
	override(edu.iris.Fissures.IfDataSetMgr.MotionVectorNodeHelper.id(),
		    new MotionVectorNodeValueFactory());
	override(edu.iris.Fissures.IfDataSetMgr.SeismogramNodeHelper.id(),
		    new SeismogramNodeValueFactory());
    }
}// IfDataSetMgrRegisterVT
