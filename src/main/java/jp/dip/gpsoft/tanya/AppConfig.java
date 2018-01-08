package jp.dip.gpsoft.tanya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
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

	@Bean
	public Logger logger(InjectionPoint ip) {
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
	}
}
