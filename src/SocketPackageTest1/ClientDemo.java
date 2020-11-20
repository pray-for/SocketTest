package SocketPackageTest1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：发送数据，接收服务器反馈
 * 服务器：接收数据，给出反馈
 */
//客户端——先写后读
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端 Socket 对象（Socket）
        Socket s = new Socket("222.24.30.171", 10000);

        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("Helle,TCP".getBytes());

        //接收服务器反馈
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("客户端：" + data);

        //释放资源
        s.close();

    }
}
