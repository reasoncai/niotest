package com.cai.niotest.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by reason on 17/1/23.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The TimeServer is start in port: "+port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                Thread thread = new Thread(new TimeServerHandler(socket));
                thread.setName("处理");
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                System.out.println("The TimeServer closed");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
