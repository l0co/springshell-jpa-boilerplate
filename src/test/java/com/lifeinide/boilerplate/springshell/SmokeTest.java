package com.lifeinide.boilerplate.springshell;

import com.lifeinide.boilerplate.springshell.repository.UserRepository;
import com.lifeinide.boilerplate.springshell.test.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SmokeTest extends AbstractIntegrationTest {

	@Autowired protected UserRepository userRepository;

	@Test
	void contextLoads() {
	}

}
