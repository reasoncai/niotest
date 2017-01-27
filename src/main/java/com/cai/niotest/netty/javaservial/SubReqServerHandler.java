package com.cai.niotest.netty.javaservial;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by reason on 17/1/25.
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReq req = (SubscribeReq) msg;
        System.out.println("Server accept client subscribe req : ["+req.toString()+"]");
        ctx.writeAndFlush(resp(req.getSubReqID()));
    }

    private SubscribeResp resp(int subReqID) {
        SubscribeResp sr = new SubscribeResp();
        sr.setSubReqID(subReqID);
        sr.setRespCode(0);
        sr.setDesc("succeed");
        return sr;
    }
}
