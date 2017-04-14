package poc.raviraj.cxfrspoc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poc.raviraj.cxfrspoc.dao.UserDAO;
import poc.raviraj.cxfrspoc.model.User;

@Controller
@RequestMapping(value = "/users")
public class UserRestController {

	@Autowired
	UserDAO userDao;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> save(@RequestBody User user) {
		User u = userDao.save(user);
		if (u != null && u.getUserId() > 0) {
			return new ResponseEntity<User>(HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{userId}/{version}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable("userId") Long userId, @PathVariable("version") Long version) {
		User deleteUser = new User();
		deleteUser.setUserId(userId);
		deleteUser.setVersion(version);
		User u = userDao.delete(deleteUser);
		if (u == null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> find(@PathVariable("userId") Long userId) {
		User u = userDao.find(userId);
		if (u != null && u.getUserId() > 0) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> findAll(@RequestParam(value = "search", defaultValue = "") String searchText) {
		List<User> list = null;
		if (searchText.length() == 0) {
			list = userDao.findAll();
		} else {
			searchText = searchText + "%";
			list = userDao.findAllByFirstNameOrLastNameOrUsername(searchText);
		}
		if (!(list == null || list.isEmpty())) {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}

}
