package SocketPackageTest6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自于文本文件，接收服务器反馈；
 * 服务器：接收到的数据写入文本文件，给出反馈，用线程进行封装，为每个客户端开启一个线程；
 */
//服务器端
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器 Socket 对象
        ServerSocket ss = new ServerSocket(10000);

        while (true) {  //服务器是一直开着的
            //监听客户端连接，返回一个对应的 Socket 对象
            Socket s = ss.accept();
            //为每个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
