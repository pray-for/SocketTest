package SocketPackageTest1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：发送数据，接收服务器反馈
 * 服务器：接收数据，给出反馈
 */
//服务器端——先读后写
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器端的 Socket 对象（ServerSocket）
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接，返回一个 Socket 对象
        Socket s = ss.accept();

        //获取输入流，读数据，并把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len  = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("服务器：" + data);

        //给出反馈
        OutputStream os = s.getOutputStream();
        os.write("数据已经收到".getBytes());

        //释放资源
        ss.close();
    }
}
