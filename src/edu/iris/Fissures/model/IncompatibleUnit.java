
package edu.iris.Fissures.model;

/**
 * IncompatibleUnit.java
 * Signifies that two units are not convertable to one another. So any 
 * values associated with these units cannot be compared, added, or subtracted.
 *
 *
 * Created: Fri Oct  1 14:43:19 1999
 *
 * @author Philip Crotwell
 * @version
 */

public class IncompatibleUnit extends Exception {
    
    public IncompatibleUnit() {
        
    }
        
    public IncompatibleUnit(String s) {
        super(s);
    }
    
} // IncompatibleUnit
