import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asia on 2016/7/5.
 * 需求：功能二的第三个虚拟机客户端
 */
public class Client5 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //监听端口3005，即监听client2端
        ServerSocket ss = new ServerSocket(3005);
        //ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        Socket s8 = new Socket("10.108.70.140", 3011);//TODO 没写下个功能的地址
        if(s.isConnected()) {
            System.out.print("client5 and client2 connected.\r\n");
        }
        if (s8.isConnected()) {
            System.out.print("client5 and server connected.\r\n");
        }
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            line = br.readLine();
            if (line != null &&!line.equals("null")) {
                System.out.println(line);
                //Thread.sleep(120);
                //睡眠0.2秒后发送给下一个功能
                if (s8.isConnected()) {
                    PrintStream ps1 = new PrintStream(s8.getOutputStream());
                    ps1.println(line);    //TODO 输出是字节流，line是字符流，估计这会出错
                }
            }
        }
    }
}
