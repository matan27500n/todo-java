package com.matan.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matan.rest.webservices.restfulwebservices.jwt.JwtUserDetails;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserJpaResource {

	@Autowired
	private static UserJpaRepository userJpaRepository;

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	@PostMapping("/register-user")
	public static ResponseEntity<Void> registerUser(@RequestBody User user) {
		userJpaRepository.save(user);
		inMemoryUserList.add(new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), "Customer"));
		return ResponseEntity.ok().build();
	}
}
