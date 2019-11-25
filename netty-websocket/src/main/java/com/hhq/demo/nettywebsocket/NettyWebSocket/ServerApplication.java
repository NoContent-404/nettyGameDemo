package com.hhq.demo.nettywebsocket.NettyWebSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerApplication {

    @Autowired
    @Qualifier("bootstrap")
    public ServerBootstrap serverBootstrap;

    public Channel channel;

    public void start() throws Exception {
        System.out.println("Netty 启动");
        channel = serverBootstrap.bind(9998).sync().channel().closeFuture().sync().channel();
    }

    public void close() throws Exception {
        channel.close();
        channel.parent().close();
    }












//    @Autowired
//    @Qualifier("bootstrap")
//    private ServerBootstrap serverBootstrap;
//
//    private Channel channel;
//
//    public void start() throws Exception {
//        System.out.println("netty启动");
//        serverBootstrap.bind(8888).sync().channel().closeFuture().sync();
//
//    }
//
//    public void close() {
//        channel.close();
//        channel.parent().close();
//    }
}
