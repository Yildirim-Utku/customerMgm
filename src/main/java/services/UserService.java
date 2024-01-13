package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.User;
import repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addOneUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(User userId) {
		userRepository.delete(userId);
	}

}
