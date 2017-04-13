package poc.raviraj.cxfrspoc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import poc.raviraj.cxfrspoc.model.User;

@Transactional
@Repository(value = "userDao")
public class UserDAO extends AbstractDAO {

	public User save(User user) {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		if (user.getUserId() == 0) {
			session.save(user);
		} else {
			session.update(user);
		}
		tx.commit();		
		session.close();
		return user;
	}

	public User delete(User user) {
		Session session = getSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		System.out.println("Delete user called for ID: " + user.getUserId());
		session.delete(user);
		
		User deletedUser = (User) session.get(User.class, user.getUserId());
		System.out.println("After Delete user called for ID: " + user.getUserId());
		System.out.println("Before delete commit");
		tx.commit();
		System.out.println("After delete commit");
		session.close();
		return deletedUser;
	}

	public List<User> findAll() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> userList = criteria.list();
		session.close();
		return userList;

	}

	public User find(Long userId) {
		Session session = getSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	public List<User> paginated(int pageNumber, int perPageLimit) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setFirstResult(pageNumber * perPageLimit - pageNumber);
		criteria.setFetchSize(perPageLimit);
		@SuppressWarnings("unchecked")
		List<User> userList = criteria.list();
		session.close();
		return userList;
	}
	
	public List<User> findAllByFirstNameOrLastNameOrUsername(String searchText) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.or(Restrictions.like("firstName", searchText), Restrictions.like("lastName", searchText), Restrictions.like("userName", searchText)));
		@SuppressWarnings("unchecked")
		List<User> userList = criteria.list();
		session.close();
		return userList;
	}
}
