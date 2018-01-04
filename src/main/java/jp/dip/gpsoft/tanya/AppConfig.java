package jp.dip.gpsoft.tanya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

	@Bean
	@Profile("use_normalagent")
	public IAgent agent() {
		return new Agent();
	}

	@Bean
	@Profile("use_specialagent")
	public IAgent specialAgent() {
		return new SpecialAgent();
	}
}
