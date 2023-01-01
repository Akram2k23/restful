package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
//	JPA/Hibernate > Database
//	UserDaoService > Static List
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User findOne(int id) {

//		User userr = users.stream().filter(e -> e.getId().equals(id)).findFirst().get();

		User userr = users.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
		
		
//		for(User usr : users) {
//			if(usr.getId() == id) {
//				break;
//			}
//		}
		return userr;
	}
	
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	
	public void deleteById(int id) {
//		Predicate<? super User> predicate = user -> user.getId().equals(id);
//		users.removeIf(predicate);

//		User userr = users.stream().filter(e -> e.getId().equals(id)).findFirst().get();

		User userr = users.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
		
		users.remove(userr);
		
	}
	

}
