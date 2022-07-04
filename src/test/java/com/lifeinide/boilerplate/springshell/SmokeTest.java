package com.lifeinide.boilerplate.springshell;

import com.lifeinide.boilerplate.springshell.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

	@Autowired protected UserRepository userRepository;

	@Test
	void contextLoads() {
	}

}
