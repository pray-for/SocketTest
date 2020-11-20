package SocketPackage2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 接收数据：
 * 1、创建服务器端的 Socket 对象（ServerSocket）；
 * 2、监听客户端的连接，返回一个 Socket 对象；
 * 3、获取输入流，读数据，并把数据显示在控制台；
 * 4、释放资源；
 */
public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器端的 Socket 对象（ServerSocket）
        //ServerSocket(int port) 创建绑定到特定端口的服务器套接字
        ServerSocket ss = new ServerSocket(10000);

        //Socket accept() 侦听并接受到此套接字的连接
        Socket s = ss.accept();

        //获取输入流，读数据，并把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("数据是：" + data);

        //释放资源
        s.close();
        ss.close();


    }
}
