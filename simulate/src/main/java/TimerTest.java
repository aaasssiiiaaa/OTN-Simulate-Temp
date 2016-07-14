import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by asia on 16/6/22.
 * 需求：Server端定时发送器,每隔一秒发送一次
 */
public class TimerTest {
    Socket[] s;
    String[] data;
    int countData=0;
    int countSocket=0;
    //定时器,每隔一秒发送一段
    public TimerTest(Socket[] s, String[] data) {     //构造函数
        this.s = s;
        this.data = data;
    }
    public void Run()
    {
        Timer t = new Timer("hehe");
        TimerTaskCount ttc = new TimerTaskCount(t);  //循环执行发送任务
        t.schedule(ttc, 0, 667);  //TODO 设成0.5秒也可
    }
    //每隔一秒执行的任务task
    class TimerTaskCount extends TimerTask {
        private Timer t ;
        public TimerTaskCount(Timer t) {
            this.t = t;
        }
        public void run() {
            PrintStream ps = null;
            try {
                ps = new PrintStream(s[countSocket].getOutputStream()); //第一个数据发给第一个客户端
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ps != null) {
                ps.println(data[countData]);
                ps.flush();
            }
            countData++;    //数据发送的段数
            countSocket++;  //连接的客户端数（3个）
            if (countSocket >= 3) {
                countSocket = countSocket - 3;  //从第4个数据开始重新发给第一个client
            }
            if (countData >= 15) {
                ps.close();
                try {                 //关闭流s的话会一直传送null，一直！不关的话会出现连接异常
                    s[0].close();
                    s[1].close();
                    s[2].close();
                    cancel();
                    t.cancel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

