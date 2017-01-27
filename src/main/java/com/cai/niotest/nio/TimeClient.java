package com.cai.niotest.nio;

/**
 * Created by reason on 17/1/24.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new Thread(new TimeClientHandle("127.0.01",port),"TimeClient-001").start();
    }
}
