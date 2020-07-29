package br.com.creditcardcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableAsync
@SpringBootApplication
public class CreditCardControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardControlApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bcyrpt() {
		return new BCryptPasswordEncoder();
	}

}
