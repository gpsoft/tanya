package jp.dip.gpsoft.tanya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public IAgent agent() {
		return new Agent();
	}
}
