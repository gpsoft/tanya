package jp.dip.gpsoft.tanya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TanyaApplication {

	private IAgent agent;

	@Value("${logging.level.root}")
	private String logLevel;

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(TanyaApplication.class, args);
	}

	public TanyaApplication(IAgent agent) {
		this.agent = agent;
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			test();
		};
	}

	private void test() {
		System.out.println("Hello, world!");
		Logger logger = LoggerFactory.getLogger(TanyaApplication.class);
		logger.warn("Log level is " + logLevel);
		logger.warn("Active profiles are "
				+ String.join(",", env.getActiveProfiles()));

		agent.help();
	}
}
