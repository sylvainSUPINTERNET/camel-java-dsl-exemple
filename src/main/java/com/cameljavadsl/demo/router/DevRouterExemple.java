package com.cameljavadsl.demo.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class DevRouterExemple extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jmsComponentActiveMQ:queue:codeusingjava-inputqueue").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println(exchange.getIn().getBody());
			}
		}).to("jmsComponentActiveMQ2:queue:codeusingjava-outputqueue");
	}

}