package com.cai.niotest.netty.javaservial;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by reason on 17/1/26.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    public SubReqClientHandler() {
        super();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i) {
        SubscribeReq subscribeReq = new SubscribeReq();
        subscribeReq.setAddress("pingsha");
        subscribeReq.setPhoneNumber("13100000000");
        subscribeReq.setSubReqID(i);
        subscribeReq.setProductName("macbook");
        subscribeReq.setUserName("cairuisen");
        return subscribeReq;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : ["+msg+"]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
