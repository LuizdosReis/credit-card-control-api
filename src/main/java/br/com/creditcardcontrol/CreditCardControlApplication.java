package br.com.creditcardcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CreditCardControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardControlApplication.class, args);
	}

}
