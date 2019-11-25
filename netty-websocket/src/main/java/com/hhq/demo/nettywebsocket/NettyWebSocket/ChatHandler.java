package com.hhq.demo.nettywebsocket.NettyWebSocket;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


//    private Logger log = LoggerFactory.getLogger(getClass());
    //private PlayerActionEnums playerActionEnums;

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有一个玩家上线");

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        String cont = msg.text();
        System.out.println("数据" + cont);
        //  转JSON
        JSONObject  json = JSONObject.parseObject(cont);


        //  获取对应的值
        System.out.println(json.get("cmd"));
            Channel currentChannel  = ctx.channel();
            System.out.println(currentChannel);
            if(msg instanceof WebSocketFrame){
                for (Channel channel : channels) {
                    if(channel != currentChannel ){
                        channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress() + ":" + json));
                    }else {
                        channel.writeAndFlush(new TextWebSocketFrame("我自己 :" +  json));
                    }

                }
            }

//        System.out.println("内容 : " + sb);


    }

    //  进入
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress() + "进入房间"));

        }
        channels.add(ctx.channel());
    }


    //  退出
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress() + ": 离开房间"));

        }
    }
}
