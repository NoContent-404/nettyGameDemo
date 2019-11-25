package com.hhq.demo.nettywebsocket;

import com.hhq.demo.nettywebsocket.NettyWebSocket.ServerApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.hhq.demo.nettywebsocket")
public class NettyWebsocketApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(NettyWebsocketApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(NettyWebsocketApplication.class, args);
        ServerApplication serverApplication = context.getBean(ServerApplication.class);
        serverApplication.start();















//		ConfigurableApplicationContext context = SpringApplication.run(NettyWebsocketApplication.class, args);
//
//        ServerApplication serverApplication = context.getBean(ServerApplication.class);
//        serverApplication.start();
    }

}
