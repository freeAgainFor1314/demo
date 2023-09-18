package com.testwe.mobile.socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOLearn {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9998);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        while (true){
            byte[] b = new byte[1024];
            int read = inputStream.read(b);
            if(-1 == read){
                break;
            }else{
                System.out.println(Thread.currentThread().getName()+" : content: "+new String(b,0,b.length));
            }
        }
        inputStream.close();
        serverSocket.close();
    }
}
