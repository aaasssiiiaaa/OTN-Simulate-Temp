import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by template on 16-7-13.
 *
 */
public class Client7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //监听端口3007，即监听client4端
        ServerSocket ss = new ServerSocket(3007);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        Socket s9 = new Socket("10.108.70.140", 3010); //connect server
        if(s.isConnected()) {
            System.out.print("client4 and client7 connected.\r\n");
        }
        if (s9.isConnected()) {
            System.out.print("client7 and server connected.\r\n");
        }
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            line = br.readLine();
            if (line != null && !line.equals("null")) {
                System.out.println(line);
                //睡眠0.3秒后发送给下一个功能
                Thread.sleep(100);
                if (s9.isConnected()) {
                    PrintStream ps1 = new PrintStream(s9.getOutputStream());
                    ps1.println(line);
                    ps1.flush();
                }
            }
        }
    }
}
