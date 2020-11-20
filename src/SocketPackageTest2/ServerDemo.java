package SocketPackageTest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自键盘录入，直到输入数据是886，发送数据结束；
 * 服务器：接收到的数据在控制台输出；
 */
//服务器
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器 Socket 对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端的连接，返回一个对应的 Socket 对象
        Socket s = ss.accept();

        //获取输入流
//        InputStream is = s.getInputStream();  //获得输入流
//        InputStreamReader isr = new InputStreamReader(is);    //转成字符流
//        BufferedReader br = new BufferedReader(isr);  //包装成buffer
        //可以合成下面一句代码
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        //释放资源
        ss.close();

    }
}
