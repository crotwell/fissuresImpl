package edu.iris.Fissures.model;

import edu.iris.Fissures.GlobalArea;

/**
 * GlobalAreaImpl.java
 *
 *
 * Created: Thu Dec  6 20:15:07 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class GlobalAreaImpl extends GlobalArea {
    public GlobalAreaImpl (){
	
    }

    public static java.io.Serializable createEmpty() {
        return new GlobalAreaImpl();
    }
}// GlobalAreaImpl
