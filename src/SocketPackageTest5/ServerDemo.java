package SocketPackageTest5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自于文本文件，接收服务器反馈；
 * 服务器：接收到的数据写入文本文件，给出反馈；
 */
//服务器端
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器 Socket 对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接，返回一个对应的 Socket 对象
        Socket s = ss.accept();

        //接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\java\\SocketTest\\Copy.java"));

        String line;
        while ((line = br.readLine()) != null){ //等待读取数据
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功");
        bwServer.newLine();
        bwServer.flush();

        //释放资源
        bw.close();
        ss.close();
    }
}