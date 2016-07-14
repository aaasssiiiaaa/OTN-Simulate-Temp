import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by asia on 2016/7/5.
 * 需求：功能二的第二个虚拟机客户端
 */
public class Client4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //监听端口3004，即监听client1端
        ServerSocket ss = new ServerSocket(3004);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        //Socket s7 = new Socket("10.108.70.140", 3010);
        Socket s7 = new Socket("10.108.49.149", 3007);
        if(s.isConnected()) {
            System.out.print("client1 and client4 connected.\r\n");
        }
        if (s7.isConnected()) {
            System.out.print("client4 and client7 connected.\r\n");
        }
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            line = br.readLine();
            if (line != null &&!line.equals("null")) {
                System.out.println(line);
                //睡眠0.2秒后发送给下一个功能
                Thread.sleep(200);
                if (s7.isConnected()) {
                    PrintStream ps1 = new PrintStream(s7.getOutputStream());
                    ps1.println(line);
                    ps1.flush();
                }
            }
        }
    }
}
