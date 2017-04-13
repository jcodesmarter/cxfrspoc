package poc.raviraj.cxfrspoc.service;

import java.util.List;

import poc.raviraj.cxfrspoc.model.Department;
import poc.raviraj.cxfrspoc.model.Designation;
import poc.raviraj.cxfrspoc.model.Gender;
import poc.raviraj.cxfrspoc.model.Role;

public interface MasterTypeService {

	public List<Department> getAllDepartments();
	
	public List<Designation> getAllDesignations();
	
	public List<Role> getAllRoles();
	
	public List<Gender> getAllGenders();
}
