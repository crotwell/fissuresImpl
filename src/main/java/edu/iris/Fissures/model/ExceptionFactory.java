package edu.iris.Fissures.model;

import edu.iris.Fissures.Error;
import edu.iris.Fissures.FissuresException;
import edu.iris.Fissures.ILLEGAL_ATTRIBUTE;
import edu.iris.Fissures.ILLEGAL_PARM;
import edu.iris.Fissures.NOT_FOUND;
import edu.iris.Fissures.IfSeismogramDC.INVALID_REQUEST;
import edu.iris.Fissures.IfSeismogramDC.SERVER_BUSY;
import edu.iris.Fissures.IfTimeSeries.ILLEGAL_CONVERSION;

/**
 * ExceptionFactory.java
 *
 *
 * Created: Fri Feb 25 13:00:15 2000
 *
 * @author Philip Crotwell
 * @version
 */

public class ExceptionFactory  {

    public static FissuresException ILLEGAL_ATTRIBUTE(String small, 
                                                      String desc) {
        return new FissuresException("Illegal Attribute: "+small,
                                     new Error(ILLEGAL_ATTRIBUTE.value,
                                               desc));
    }

    public static FissuresException ILLEGAL_PARM(String small, String desc) {
        return new FissuresException("Illegal Parameter: "+small,
                                     new Error(ILLEGAL_PARM.value,
                                               desc));
    }
 
    public static FissuresException NOT_FOUND(String small, String desc) {
        return new FissuresException("NOT_FOUND: "+small,
                                     new Error(NOT_FOUND.value,
                                               desc));
    }
 
    public static FissuresException INVALID_REQUEST(String small, String desc) {
        return new FissuresException("Invalid Request: "+small,
                                     new Error(INVALID_REQUEST.value,
                                               desc));
    }
 
    public static FissuresException SERVER_BUSY(String small, String desc) {
        return new FissuresException("SERVER_BUSY: "+small,
                                     new Error(SERVER_BUSY.value,
                                               desc));
    }
 
    public static FissuresException ILLEGAL_CONVERSION(String small, 
                                                       String desc) {
        return new FissuresException("ILLEGAL_CONVERSION: "+small,
                                     new Error(ILLEGAL_CONVERSION.value,
                                               desc));
    }

} // ExceptionFactory
