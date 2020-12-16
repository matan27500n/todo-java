package com.matan.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	long id = 1;
	String username;
	String password;
	final String role = "Admin";
	Scanner scanner = new Scanner(System.in);

	static {
		// the user: admin , the password: admin
		inMemoryUserList.add(new JwtUserDetails(1L, "admin",
				"$2a$10$SiYmwETVIysqaKkwNrd6fO3KoipYqpt9I9q4WnYl0kHDDptHPLoHa", "Admin"));
	}

	public void addUser() {
		System.out.println("Enter username");
		username = scanner.next();
		System.out.println("Enter password");
		password = scanner.next();
		id++;
		inMemoryUserList.add(new JwtUserDetails(id, username, password, role));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
