package com.demo.websocket.config;

import com.demo.websocket.WebSocketInterceptor;
import com.demo.websocket.WebSocketServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Bean
    public WebSocketInterceptor getWebSocketInterceptor() {
        return new WebSocketInterceptor();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 此处定义webSocket的连接地址以及允许跨域
        registry.addHandler(myHandler(), "/websocket").addInterceptors(getWebSocketInterceptor()).setAllowedOrigins("*");
        // 同上，同时开启了Sock JS的支持，目的为了支持IE8及以下浏览器
        registry.addHandler(myHandler(), "/sockjs/websocket").addInterceptors(getWebSocketInterceptor()).setAllowedOrigins("*").withSockJS();
    }
    @Bean
    public WebSocketServer myHandler() {
        return new WebSocketServer();
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
