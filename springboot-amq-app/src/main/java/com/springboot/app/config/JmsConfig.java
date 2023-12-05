/**
 * 
 */
/**
 * 
 */
package com.springboot.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig{
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionfactory) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory =new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(connectionfactory);
		jmsListenerContainerFactory.setConcurrency("5-10");
		
		return jmsListenerContainerFactory;
	}
	
}