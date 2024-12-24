package com.Microservices.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
