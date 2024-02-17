package com.hexaware.ITAssets.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ITAssetsConfig {
	@Bean
    ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
