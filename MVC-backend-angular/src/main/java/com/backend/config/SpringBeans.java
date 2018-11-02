/**
 * 
 */
package com.backend.config;


import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author m.BOUABID
 * 
 * @EnableTransactionManagement --> to replace <tx:annotation-driven/> of application-context.xml and enable the transaction
 */
@Configuration
@ComponentScan("com.backend")
@EnableTransactionManagement
public class SpringBeans {


	
	/**
	 * Model mapper BEAN provider Configuration
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	

}
