import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asia on 2016/6/21.
 * 需求：监听client端。用于监听来自server的连接请求,功能一解帧（延时），并发送给下一功能
 * 思路：1.监听数据
 *       2.延时
 *       3.发送数据
 */

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        ListenThread lt = new ListenThread();
        lt.start();
        //TODO 怎么进行两个线程之间的数据交互：存全局，共用这个全局空间
        SendThread st = new SendThread();
        st.start();
        */
        //监听端口3000，即监听server端
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        if(s.isConnected()) {
            System.out.print("client0 and server connected.\r\n");
        }
        Socket s3 = new Socket("10.108.48.144", 3003); //连client3
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,InputStreamReader是字符流,InputStream是字节流,该句括号作用是转换
            line = br.readLine();
            if (line != null&& !line.equals("null")) {
                System.out.println(line);
                //睡眠0.3秒后发送给下一个功能
//                Thread.sleep(100);
                if (s3.isConnected()) {
                    System.out.print("client0 and client3 is connected.\r\n");
                }
                PrintStream ps1 = new PrintStream(s3.getOutputStream());
                ps1.println(line);
            }
        }
    }
}

/*
 class ListenThread extends Thread{
    public void run(){
        //监听端口连接请求，并接收server端数据
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();         //accept返回值就是一个socket
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            String line = br.readLine();
            System.out.println(line);
            //br.close();
            //s.close();
        }
    }
}
class SendThread extends Thread{
    public void run(){
        //发送给下一个功能的client
        Socket s1 = new Socket("",3001);
        if(s1.isConnected()) {
            System.out.print("connected.\r\n");
        }
        Thread.sleep(300);     //TODO 线程睡眠在这可以吗？还是要在主函数
        PrintStream ps1 = new PrintStream(new OutputStreamWriter(s1.getOutputStream()));
        ps1.print(line);
    }*/



