package edu.iris.Fissures.dataSetMgr;

import org.omg.CORBA.NO_IMPLEMENT;
import edu.iris.Fissures.AuditElement;
import edu.iris.Fissures.NotImplemented;
import edu.iris.Fissures.IfDataSetMgr.DataSet;
import edu.iris.Fissures.IfDataSetMgr.DataSetAccess;
import edu.iris.Fissures.IfDataSetMgr.DataSetAttr;
import edu.iris.Fissures.IfDataSetMgr.LocalDataSet;
import edu.iris.Fissures.IfDataSetMgr.MotionVectorNode;
import edu.iris.Fissures.IfDataSetMgr.NotADataSet;
import edu.iris.Fissures.IfDataSetMgr.NotFound;
import edu.iris.Fissures.IfDataSetMgr.SeismogramNode;
import edu.iris.Fissures.IfSeismogramDC.LocalMotionVector;
import edu.iris.Fissures.IfSeismogramDC.LocalSeismogram;

/**
 * LocalDataSetImpl.java
 *
 *
 * Created: Thu Dec  6 17:12:32 2001
 *
 * @author <a href="mailto:">Philip Crotwell</a>
 * @version
 */

public class LocalDataSetImpl extends LocalDataSet {


    /** Empty constructor to be used only for valuetype marshaling. */
    protected LocalDataSetImpl (){
    }

    /** A factory method to create an empty LocalDataSetImpl. 
     *  This is to be used only by the ORB for unmarshelling
     *  valuetypes that have been sent via IIOP.
     */
    public static java.io.Serializable createEmpty() {
        return new LocalDataSetImpl();
    }

    public LocalDataSetImpl(DataSetAttr attr) {
	this.attributes = attr;
	datasets = new DataSetAccess[0];
	seismograms = new SeismogramNode[0];
	motion_vectors = new MotionVectorNode[0];
	local_seis = new LocalSeismogram[0];
	local_motion = new LocalMotionVector[0];
	audit_trail = new AuditElement[0];
    }

    public LocalSeismogram[] getLocalSeismograms() {
	return local_seis;
    }

    public LocalMotionVector[] getLocalModtionVectors() {
	return local_motion;
    }

    /** Add a child local seismogram */
    public void addLocalSeismogram(LocalSeismogram a_seismogram,
				   edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	LocalSeismogram[] tmp = new LocalSeismogram[local_seis.length+1];
	System.arraycopy(local_seis, 0, tmp, 0, local_seis.length);
	tmp[tmp.length-1] = a_seismogram;
	local_seis = tmp;
    }

    /** Add an array of child local seismograms */
    public void addLocalSeismogram(LocalSeismogram[] a_seismogram,
				   edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	LocalSeismogram[] tmp = new LocalSeismogram[local_seis.length+a_seismogram.length];
	System.arraycopy(local_seis, 0, tmp, 0, local_seis.length);
	System.arraycopy(a_seismogram, 0, tmp, local_seis.length, a_seismogram.length);
	local_seis = tmp;
    }

    // DataSetAccess
    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/a_writeable:1.0
    //
    /** Navigation to a reference that allows updates */

    public DataSet
	a_writeable() {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/parm_svc:1.0
    //
    /** Defines the ParameterMgr where parameters for this DataSet
     *reside */

    public edu.iris.Fissures.IfParameterMgr.ParameterComponent
	parm_svc() {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/localize:1.0
    //
    /** Retrieve a local copy of this dataset*/

    public LocalDataSet
	localize() {
	return this;
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/get_attributes:1.0
    //
    /** Retrieve the attributes */

    public DataSetAttr
	get_attributes() {
	return attributes;
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/get_datasets:1.0
    //
    /** Retrieve the dataset that are children of this dataset */

    public DataSetAccess[]
	get_datasets() {
	return datasets;
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/get_motion_vectors:1.0
    //
    /** Retrieve the motion vectors that are children of this dataset.
     **/

    public MotionVectorNode[]
	get_motion_vectors() {
	return motion_vectors;
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSetAccess/get_seismograms:1.0
    //
    /** Retrieve the seismograms that are children of this dataset */

    public SeismogramNode[]
	get_seismograms() {
	return seismograms;
    }

    // end DataSetAccess

    // DataSet

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/destroy:1.0
    //
    /** Delete this DataSet from the service presistent storage. Also,
     *  for all MotionVector or Seismogram children that are not
     *  children of any other DataSet delete them from the service
     *  presistent store.
     **/

    public void
	destroy() {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/update_dataset:1.0
    //
    /** Update the attributes of the dataset */

    public void
    update_dataset(DataSetAttr dataset_attr,
                   edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/add_dataset:1.0
    //
    /** Add a child dataset */

    public void
    add_dataset(DataSetAccess a_dataset,
                edu.iris.Fissures.AuditInfo[] audit_info)
        throws NotFound,
	NotADataSet {
	DataSetAccess[] tmp = new DataSetAccess[datasets.length+1];
	System.arraycopy(datasets, 0, tmp, 0, datasets.length);
	tmp[datasets.length]=a_dataset;
	datasets = tmp;
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/add_motion_vector:1.0
    //
    /** Add a child motion vector */

    public String
    add_motion_vector(MotionVectorNode a_motion_vector,
                      edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/add_seismogram:1.0
    //
    /** Add a child motion seismogram */

    public String
    add_seismogram(edu.iris.Fissures.IfSeismogramMgr.SeismogramAccess a_seismogram,
                   edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	throw new NO_IMPLEMENT();
    }

    //
    // IDL:iris.edu/Fissures/IfDataSetMgr/DataSet/remove_node:1.0
    //
    /** Remove a node from the DataSet. If the Node is a MotionVector
     * or Seismogram and not a child of any other DataSet delete it
     * from the service presistent store.
     **/

    public void
    remove_node(String a_node,
                edu.iris.Fissures.AuditInfo[] audit_info)
        throws edu.iris.Fissures.FissuresException {
	throw new NO_IMPLEMENT();
    }

    // end DataSet

    // AuditSystemAccess

    //
    // IDL:iris.edu/Fissures/AuditSystemAccess/get_audit_trail:1.0
    //
    /***/

    public AuditElement[]
    get_audit_trail()
        throws NotImplemented {
	throw new NotImplemented();
    }

    //end AuditSystemAccess

}// LocalDataSetImpl
