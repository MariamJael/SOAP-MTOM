package com.assignment3.ws.soap.config;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment3.ws.soap.FileWsImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint(){
		//create and enable a new endpoint for this web service
		Endpoint endpoint = new EndpointImpl(bus, new FileWsImpl());
		endpoint.publish("/FileWs");
		
		//create a variable of SOAPBinding and cast the result returned from the endpoint
		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
		binding.setMTOMEnabled(true);
		
		return endpoint;
	}

}
