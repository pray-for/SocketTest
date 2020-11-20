package SocketPackageTest3;
import java.io.*;
import java.net.Socket;

/**
 * TCP 通信程序练习
 * 客户端：数据来自键盘录入，直到输入数据是886，发送数据结束；
 * 服务器：接收到的数据写入文本文件；
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
            if ("886".equals(line)){
                break;
            }
            bw.write(line); //读一行
            bw.newLine();   //换一行
            bw.flush();     //刷新
        }

        //释放资源
        s.close();

    }
}
