package poc.raviraj.cxfrspoc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poc.raviraj.cxfrspoc.dao.MasterTypeDAO;
import poc.raviraj.cxfrspoc.model.Department;
import poc.raviraj.cxfrspoc.model.Designation;
import poc.raviraj.cxfrspoc.model.Gender;
import poc.raviraj.cxfrspoc.model.Role;

@Controller
@RequestMapping(value = "mastertypes")
public class MasterTypeRestController {

	@Autowired
	MasterTypeDAO masterTypeDAO;

	@RequestMapping(value = "departments", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> list = masterTypeDAO.getAllDepartments();
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "designations", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Designation>> getAllDesignations() {
		List<Designation> list = masterTypeDAO.getAllDesignations();
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<List<Designation>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Designation>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "roles", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> list = masterTypeDAO.getAllRoles();
		;
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "genders", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Gender>> getAllGenders() {
		List<Gender> list = masterTypeDAO.getAllGenders();
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<List<Gender>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Gender>>(list, HttpStatus.OK);
	}
}
