
package edu.iris.Fissures.network;

import edu.iris.Fissures.model.RegisterVT;

/**
 * IfNetworkVTFactory.java
 *
 *
 * Created: Thu Dec 14 12:35:00 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class IfNetworkRegisterVT extends RegisterVT {
    
    public IfNetworkRegisterVT() {
	override(edu.iris.Fissures.IfNetwork.CalibrationHelper.id(),
		    new CalibrationValueFactory());
	override(edu.iris.Fissures.IfNetwork.ChannelHelper.id(),
		    new ChannelValueFactory());
	override(edu.iris.Fissures.IfNetwork.ClockHelper.id(),
		    new ClockValueFactory());
	override(edu.iris.Fissures.IfNetwork.DataAcqSysHelper.id(),
		    new DataAcqSysValueFactory());
	override(edu.iris.Fissures.IfNetwork.InstrumentationHelper.id(),
		    new InstrumentationValueFactory());
	override(edu.iris.Fissures.IfNetwork.NetworkAttrHelper.id(),
		    new NetworkAttrValueFactory());
	override(edu.iris.Fissures.IfNetwork.OrientationRangeHelper.id(),
		    new OrientationRangeValueFactory());
	override(edu.iris.Fissures.IfNetwork.SamplingRangeHelper.id(),
		    new SamplingRangeValueFactory());
	override(edu.iris.Fissures.IfNetwork.SeismicHardwareHelper.id(),
		    new SeismicHardwareValueFactory());
	override(edu.iris.Fissures.IfNetwork.SensorHelper.id(),
		    new SensorValueFactory());
	override(edu.iris.Fissures.IfNetwork.SiteHelper.id(),
		    new SiteValueFactory());
	override(edu.iris.Fissures.IfNetwork.StationHelper.id(),
		    new StationValueFactory());
	override(edu.iris.Fissures.IfNetwork.TimeCorrectionHelper.id(),
		    new TimeCorrectionValueFactory());
    }
    
} // IfNetworkVTFactory
