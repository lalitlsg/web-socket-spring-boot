package com.websockets.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // add websocket endpoint, set allowed origin patterns to avoid cors, and enable SockJS
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
            .addEndpoint("/ws")
            .setAllowedOriginPatterns("*")
            .withSockJS();
    }

    // configure message broker, add app prefixes, add agent prefix for private messaging
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry
            .enableSimpleBroker("/chatroom", "/user", "/agent");
        registry.setUserDestinationPrefix("/user");
        registry.setUserDestinationPrefix("/agent");
    }
}
