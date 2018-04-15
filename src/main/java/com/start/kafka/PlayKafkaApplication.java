package com.start.kafka;

import com.start.kafka.consumer.MessageListener;
import com.start.kafka.model.Greetings;
import com.start.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class PlayKafkaApplication {

	@Autowired
	MessageProducer messageProducer;

	@Autowired
	MessageListener messageListener;

	public static void main(String[] args)
	{
		SpringApplication.run(PlayKafkaApplication.class, args);
	}

	@Scheduled(fixedDelay = 5000)
	private void produce(){
		messageProducer.sendGreetingMessage(new Greetings("Hello","name"));
	}
}
