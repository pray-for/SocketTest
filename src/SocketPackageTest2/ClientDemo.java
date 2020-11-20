package SocketPackageTest2;

import java.io.*;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自键盘录入，直到输入数据是886，发送数据结束；
 * 服务器：接收到的数据在控制台输出；
 */
//客户端
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端 Socket 对象
        Socket s =  new Socket("222.24.30.171", 10000);

        //数据来自于键盘录入，直到输入数据是886，发送数据结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null){
            //如果是“886”，则退出循环，发送结束
            if ("886".equals(line)){
                break;
            }
            //如果不是“886”，就要把数据发送出去

            //获取输出流对象
            //（字符数组）
//            OutputStream os = s.getOutputStream();
//            os.write(line.getBytes());

            //（字符串）
            bw.write(line); //读一行
            bw.newLine();   //换一行
            bw.flush();     //刷新
        }

        //释放资源
        s.close();
    }
}
