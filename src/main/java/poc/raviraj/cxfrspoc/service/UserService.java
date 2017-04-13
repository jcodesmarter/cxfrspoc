package poc.raviraj.cxfrspoc.service;

import java.util.List;

import poc.raviraj.cxfrspoc.model.User;

public interface UserService {

	public User save(User user);

	public User delete(User user);

	public List<User> findAll();

	public User find(Long userId);

	public List<User> paginated(int pageNumber, int perPageLimit);

	public List<User> findAllByFirstNameOrLastNameOrUsername(String searchText);
}
