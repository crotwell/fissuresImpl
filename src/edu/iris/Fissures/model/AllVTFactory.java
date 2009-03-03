
package edu.iris.Fissures.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.omg.CORBA.portable.ValueFactory;


/**
 * AllVTFactory.java
 *
 *
 * Created: Thu Dec 14 19:22:05 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class AllVTFactory  {
    
    public AllVTFactory() {
	vtRegister = new LinkedList();
	vtRegister.add(new FissuresVTFactory());
	vtRegister.add(new edu.iris.Fissures.event.IfEventRegisterVT());
	vtRegister.add(new edu.iris.Fissures.network.IfNetworkRegisterVT());
	vtRegister.add( 
	    new edu.iris.Fissures.seismogramDC.IfSeismogramDCRegisterVT());
	vtRegister.add(
	    new edu.iris.Fissures.dataSetMgr.IfDataSetMgrRegisterVT());
    }

    public void register(org.omg.CORBA_2_3.ORB orb) {
	Map map;
	Iterator it;
	String id;
	Iterator vtRegIterator = vtRegister.iterator();
	while (vtRegIterator.hasNext()) {
	    RegisterVT current = (RegisterVT)vtRegIterator.next();
	    map = current.getVTFactoryNames();
	    it = map.keySet().iterator();
	    while (it.hasNext()) {
		id = (String)it.next();
		orb.register_value_factory(id, (ValueFactory)map.get(id));
	    }
	}
    }
    
    protected LinkedList vtRegister;

} // AllVTFactory
