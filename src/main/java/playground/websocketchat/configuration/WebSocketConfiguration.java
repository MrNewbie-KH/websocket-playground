package playground.websocketchat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    //    two parts
//    part 1 handshake and connect
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        establish connection via http and upgrade to websocket
        registry.addEndpoint("/websocket").setAllowedOriginPatterns("*").withSockJS();
    }

    //    part 2 message handling and broker
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");

    }
}
