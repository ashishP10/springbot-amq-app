package com.springboot.app.service;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.springboot.app.Exception.FlightEventCreationException;
import com.springboot.app.model.SystemMessage;

@Service
public class EventPublisher{
	
	@Autowired
	private JmsTemplate jmstemplate;
	
	public ResponseEntity<String> publishMessage(SystemMessage systemMessage)
	{
		
		 try {
			 publishWithRetry(systemMessage);
	            return ResponseEntity.ok("Message published successfully");
	            
	        } catch (Exception e) {
	        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("Failed to publish message: " + e.getMessage());
	        }
		
	}
	private void publishWithRetry(SystemMessage message) {
        int maxRetries = 3;
        int currentRetry = 0;

        while (currentRetry < maxRetries) {
            try {
            	jmstemplate.convertAndSend("activeMq-queue", message);
                return;
            } catch (Exception e) {
                currentRetry++;
                if (currentRetry >= maxRetries) {
                    throw new FlightEventCreationException("Max retries reached.", e);
                }
                try {
                    Thread.sleep(5000); 
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}