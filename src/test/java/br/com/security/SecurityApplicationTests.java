package br.com.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


class SecurityApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passowrd = passwordEncoder.encode("Senha123");
		System.out.println(passowrd);


	}

}
