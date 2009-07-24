
package edu.iris.Fissures.model;

/**
 * FissuresVTFactory.java
 *
 *
 * Created: Thu Dec 14 19:09:05 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class FissuresVTFactory extends RegisterVT {
    
    public FissuresVTFactory() {
	override(edu.iris.Fissures.BoxAreaHelper.id(),
		 new BoxAreaValueFactory());
	override(edu.iris.Fissures.FlinnEngdahlRegionHelper.id(),
		 new FlinnEngdahlRegionValueFactory());
	override(edu.iris.Fissures.GlobalAreaHelper.id(),
		 new GlobalAreaValueFactory());
	override(edu.iris.Fissures.PointDistanceAreaHelper.id(),
		 new PointDistanceAreaValueFactory());
	override(edu.iris.Fissures.QuantityHelper.id(),
		 new QuantityValueFactory());
	override(edu.iris.Fissures.SamplingHelper.id(),
		 new SamplingValueFactory());
	override(edu.iris.Fissures.UnitHelper.id(),
		 new UnitValueFactory());
	override(edu.iris.Fissures.UnitRangeHelper.id(),
		 new UnitRangeValueFactory());
    }
    
} // FissuresVTFactory
