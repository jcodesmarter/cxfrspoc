package poc.raviraj.cxfrspoc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import poc.raviraj.cxfrspoc.model.Department;
import poc.raviraj.cxfrspoc.model.Designation;
import poc.raviraj.cxfrspoc.model.Gender;
import poc.raviraj.cxfrspoc.model.Role;

@Transactional
@Repository(value = "masterTypeDAO")
public class MasterTypeDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
		List<Department> list = null;
		try{
		Session session = getSession();
		Criteria criteria = session.createCriteria(Department.class);
		list = criteria.list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Designation> getAllDesignations() {
		Criteria criteria = getSession().createCriteria(Designation.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		Criteria criteria = getSession().createCriteria(Role.class);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Gender> getAllGenders() {
		Criteria criteria = getSession().createCriteria(Gender.class);
		return criteria.list();
	}

}
