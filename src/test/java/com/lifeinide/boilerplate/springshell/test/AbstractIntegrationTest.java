package com.lifeinide.boilerplate.springshell.test;

import com.lifeinide.boilerplate.springshell.SpringshellApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Lukasz Frankowski
 */
@SpringBootTest
@ActiveProfiles(SpringshellApplication.PROFILE_TEST)
public class AbstractIntegrationTest {
}
