
package edu.iris.Fissures.model;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ValueFactory;

/**
 * RegisterVT.java
 *
 *
 * Created: Thu Dec 14 12:27:25 2000
 *
 * @author Philip Crotwell
 * @version
 */

public abstract class RegisterVT  {
    
    public RegisterVT() {
	vtNames = new HashMap(); 
    }

    public Map getVTFactoryNames() {
	return vtNames;
    }
    
    public void override(String id, ValueFactory factory) {
	vtNames.put(id,
		    factory);
    }

    protected Map vtNames;

} // RegisterVT
