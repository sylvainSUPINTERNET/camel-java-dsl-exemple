package com.cameljavadsl.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cameljavadsl.demo.router.DevRouterExemple;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		


		try {
			CamelContext ctx = new DefaultCamelContext();
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
			ctx.addComponent("jmsComponentActiveMQ", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			ctx.addComponent("jmsComponentActiveMQ2", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
			DevRouterExemple jmsRouteBuilderDev = new DevRouterExemple();
			ctx.addRoutes(jmsRouteBuilderDev);
			ctx.start();
			// Thread.sleep(5 * 60 * 1000);
			// ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
