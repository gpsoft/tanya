package jp.dip.gpsoft.tanya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Agent agent() {
		return new Agent("Agent Walker");
	}
}
