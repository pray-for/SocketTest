package SocketPackageTest4;

import java.io.*;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自于文本文件；
 * 服务器：接收到的数据写入文本文件；
 */
//客户端
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端 Socket 对象
        Socket s = new Socket("222.24.30.171", 10000);

        //封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("F:\\java\\SocketTest\\FileTest.java"));
        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        br.close();
        s.close();

    }
}
