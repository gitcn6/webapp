package com.unicom.busi.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicom.busi.entity.Address;

@Configuration
public class AppConfig {
	
	@Bean(value="addr")
	public Address createAddress(){
		return new Address("山东省","济南市","历城区");
	}
}
