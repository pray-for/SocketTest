package SocketPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP 接收数据：
 * 1、创建接收端的 Socket 对象（DatagramSocket）；
 * 2、创建一个数据包，用于接收数据；
 * 3、调用 DatagramSocket 对象的方法接收数据；
 * 4、解析数据包，并把数据在控制台显示；
 * 5、关闭接收端；
 */
public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的 Socket 对象（DatagramSocket）
        //DatagramSocket(int port) 创建数据报套接字并将其绑定到本地主机上的指定端口
        DatagramSocket ds = new DatagramSocket(10086);

        //创建一个数据包，用于接收数据
        //DatagramPacket(byte[] buf, int length)
        //构造 DatagramPacket，用来接收长度为 length 的数据包
        byte[] bys = new byte[1024];
        int length = bys.length;
        DatagramPacket dp = new DatagramPacket(bys, length);

        //调用 DatagramSocket 对象的方法接收数据
        ds.receive(dp);

        //解析数据包，并把数据在控制台显示
        //byte[] getData() 返回数据缓冲区
        byte[] datas = dp.getData();
        //返回接收到的数据的长度
        int len = dp.getLength();
        String dataString = new String(datas, 0, len);
        System.out.println("数据是：" + dataString);

        //关闭接收端
        ds.close();
    }
}
