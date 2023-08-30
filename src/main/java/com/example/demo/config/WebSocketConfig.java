package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;
    // WebSocketHandler가 웹소켓 통신을 처리해준다.
    // addHandler() 안에 첫번째 인자로 들어가는데,
    // 여기에 new WebSocketChatHandler() 와 같이 사용자 정의 핸들러를 직접 넣어도 된다.
    // 어차피 WebSocketHandler를 상속할 것이므로 상관없다.
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // endpoint 설정 : /api/v1/chat/{postId}
        // 이를 통해서 ws://localhost:9090/ws/chat 으로 요청이 들어오면 websocket 통신을 진행한다.
        // setAllowedOrigins("*")는 모든 ip에서 접속 가능하도록 해줌
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
        /*  WebSocketHandlerRegistry에 웹소켓 엔드포인트를 /ws/chat로 설정.
            이제 ws://주소:포트/ws/chat로 요청이 들어오면 웹소켓 핸드쉐이킹을 한다.
            setAllowedOrigins("*")는 모든 cors 요청을 허용하는 것이다. */
    }
}
