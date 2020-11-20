import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 发送数据步骤：
 * 1、创建发送端的 Socket 对象（DatagramSocket）；
 * 2、创建数据，并把数据打包；
 * 3、调用 DatagramSocket 对象的方法发送数据；
 * 4、关闭发送端；
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //创建发送端的 Socket 对象（DatagramSocket）
        //DatagramSocket()  构造数据报套接字并将其绑定到本地主机上任何可用的端口
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并把数据打包
        //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
        //构造数据报包，用来将长度为 length 偏移量为 offset 的包发送到指定主机上的指定端口号
        byte[] bys = "hello".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("222.24.30.171");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bys, length, address, port);


        //调用 DatagramSocket 对象的方法发送数据
        //send(DatagramPacket p) 从此套接字发送数据报包
        ds.send(dp);

        //关闭发送端
        ds.close();
    }
}
