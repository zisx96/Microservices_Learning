package com.Microservices.routes;

import java.net.URI;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

	@Bean
	public RouterFunction<ServerResponse> service1(){
		
		return GatewayRouterFunctions.route("MICROAPP1")
				.route(RequestPredicates.path("/info"), 
						HandlerFunctions.http("http://localhost:8482"))
				.filter(CircuitBreakerFilterFunctions
						.circuitBreaker("MICROAPP1CircuitBreaker",
								URI.create("forward:/fallbackRouter")))
				.build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> fallbackRouter(){
		
		return GatewayRouterFunctions.route("fallbackRouter")
				.GET("/fallbackRouter", request-> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
						.body("Service Currently Unavailable, try again after some time"))
				.build();
	}
	
	
	@Bean
	public RouterFunction<ServerResponse> service2(){
		
		return GatewayRouterFunctions.route("MICROAPP2")
				.route(RequestPredicates.path("/details"), 
						HandlerFunctions.http("http://localhost:8486"))
				.build();
	}
}
