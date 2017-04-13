package poc.raviraj.cxfrspoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.raviraj.cxfrspoc.dao.MasterTypeDAO;
import poc.raviraj.cxfrspoc.model.Department;
import poc.raviraj.cxfrspoc.model.Designation;
import poc.raviraj.cxfrspoc.model.Gender;
import poc.raviraj.cxfrspoc.model.Role;

@Service(value="masterTypeService")
public class MasterTypeServiceImpl implements MasterTypeService {

	@Autowired
	MasterTypeDAO masterTypeDAO;

	public List<Department> getAllDepartments() {
		List<Department> list = masterTypeDAO.getAllDepartments();
		return list;
	}

	public List<Designation> getAllDesignations() {
		return masterTypeDAO.getAllDesignations();
	}

	public List<Role> getAllRoles() {
		return masterTypeDAO.getAllRoles();
	}

	public List<Gender> getAllGenders() {
		return masterTypeDAO.getAllGenders();
	}
}
