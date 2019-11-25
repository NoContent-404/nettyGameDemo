package com.hhq.demo.nettywebsocket.NettyWebSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatServer {

    @Autowired
    private ChatHandler chatHandler;

    @Bean
    public NioEventLoopGroup bossGroop (){
        return new NioEventLoopGroup();
    }
    @Bean
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public ServerBootstrap bootstrap (){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroop(),workerGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new HttpServerCodec());
                        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
                        socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
                        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/websocket"));
                        socketChannel.pipeline().addLast(chatHandler);

                    }
                })
                .option(ChannelOption.SO_BACKLOG,100)
                .childOption(ChannelOption.SO_KEEPALIVE,true);

        return serverBootstrap;
    }























//    @Autowired
//    ChatHandler chatHandler;
//
//    @Bean
//    public NioEventLoopGroup bossGroup (){
//        return new NioEventLoopGroup();
//    }
//
//    @Bean
//    public NioEventLoopGroup workerGroup(){
//        return new NioEventLoopGroup();
//    }
//
//    @Bean(name = "bootstrap")
//    public ServerBootstrap bootstrap () {
//        ServerBootstrap serverBootstrap = new ServerBootstrap();
//        serverBootstrap.group(bossGroup(),workerGroup())
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new HttpServerCodec());
//                        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
//                        socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
//                        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/websocket"));
//                        socketChannel.pipeline().addLast(chatHandler);
//                    }
//                })
//                .option(ChannelOption.SO_BACKLOG,100)
//                .childOption(ChannelOption.SO_KEEPALIVE,true);
//        return serverBootstrap;
//    }

}
