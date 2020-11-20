package SocketPackage2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 发送数据步骤：
 * 1、创建客户端的 Socket 对象（Socket）；
 * 2、获取输出流，写数据；
 * 3、释放资源；
 */
public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端的 Socket 对象（Socket）
        //Socket(InetAddress address, int port)
        //创建一个流套接字并将其连接到指定 IP 地址的指定端口号
//        Socket s = new Socket(InetAddress.getByName("222.24.30.171"), 10000);

        //Socket(String host, int port)
        //创建一个流套接字并将其连接到指定主机上的指定端口号
        Socket s = new Socket("222.24.30.171", 10000);

        //获取输出流，写数据
        // OutputStream getOutputStream() 返回此套接字的输出流
        OutputStream os = s.getOutputStream();
        os.write("hello, TCP".getBytes());

        //释放资源
        s.close();
    }
}
