package com.vti.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompomentConfiguration {

	@Bean
	public ModelMapper initModelMapper() {
		return new ModelMapper();
	}
}
