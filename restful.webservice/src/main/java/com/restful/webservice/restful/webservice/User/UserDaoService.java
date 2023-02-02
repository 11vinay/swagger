package com.restful.webservice.restful.webservice.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Arnav", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Mukesh", LocalDate.now().minusYears(28)));
		users.add(new User(++usersCount, "Ravi", LocalDate.now().minusYears(27)));
		users.add(new User(++usersCount, "Vikas", LocalDate.now().minusYears(31)));
	}

	// find all users
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	// public user save (User user)
	public User findOne(Integer id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

    //delete User
	public void deleteById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);

	}

}
