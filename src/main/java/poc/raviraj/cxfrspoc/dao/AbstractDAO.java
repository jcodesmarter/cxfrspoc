package poc.raviraj.cxfrspoc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
}
