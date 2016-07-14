import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by asia on 2016/7/5.
 * 需求：功能二的第一个虚拟机客户端
 */
public class Client3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //监听端口3003，即监听client0端
        ServerSocket ss = new ServerSocket(3003);
        Socket s = ss.accept();         //accept返回值就是一个socket
        String line;
        //Socket s6 = new Socket("10.108.70.140", 3009);
        Socket s6 = new Socket("10.108.49.3", 3006);
        if(s.isConnected()) {
            System.out.print("client0 and client3 connected.\r\n");
        }
        if (s6.isConnected()) {
            System.out.print("client3 and client6 connected.\r\n");
        }
        while (true){
//          BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); //读取输入socket的内容,buffer是字符流,stream是字节流,该句括号作用是转换
            InputStream inputStream = s.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            line = br.readLine();
            if (line != null &&!line.equals("null")) {
                System.out.println(line);
                //睡眠0.2秒后发送给下一个功能
                Thread.sleep(200);
                if (s6.isConnected()) {
                    PrintStream ps1 = new PrintStream(s6.getOutputStream());
                    ps1.println(line);
                    ps1.flush();

                }
            }

        }
    }
}
