package jp.dip.gpsoft.tanya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TanyaApplication {

	@Autowired
	private Agent agent;

	public static void main(String[] args) {
		SpringApplication.run(TanyaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			test();
		};
	}

	private void test() {
		System.out.println("Hello, world!");

		agent.help();
	}
}
