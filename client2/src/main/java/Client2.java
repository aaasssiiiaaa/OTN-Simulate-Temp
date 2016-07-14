import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asia on 2016/7/4.
 * 需求：功能一的第三个虚拟机客户端
 */
public class Client2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //监听端口3000，即监听server端
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        Socket s5 = new Socket("10.108.50.91", 3005); //connect client5
        if(s.isConnected()) {
            System.out.print("server and client2 connected.\r\n");
        }
        if (s5.isConnected()) {
            System.out.print("client2 and client5 connected.\r\n");
        }
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            line = br.readLine();
            if (line != null && !line.equals("null")) {
                System.out.println(line);
                //睡眠0.3秒后发送给下一个功能
                Thread.sleep(300);
                if (s5.isConnected()) {
                    PrintStream ps1 = new PrintStream(s5.getOutputStream());
                    ps1.println(line);
                    ps1.flush();
                }
            }
        }
    }
}
