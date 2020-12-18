package com.matan.rest.webservices.restfulwebservices.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import com.matan.rest.webservices.restfulwebservices.jwt.JwtInMemoryUserDetailsService;

@Order(value = 1)
@Service
public class Test implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		JwtInMemoryUserDetailsService service = new JwtInMemoryUserDetailsService();
		service.addUser();
	}

}
