import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by 98162 on 2016/7/13.
 *
 */
public class DataGenerateTest {
    public static void main(String[] args) throws IOException {
        final String pool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int poolSize = pool.length();
        String data[] = new String[10];
        StringBuffer str = new StringBuffer();
        long randomDataCount = 0;
        while (randomDataCount < 10485760) {
            str.append(pool.charAt((int) (Math.random() * poolSize)));
            randomDataCount++;
        }
        //切割字符串
        FileWriter writer = new FileWriter("test.txt");
        int x = 0, y = 1048576;
        for (int j = 0; j < 10; j++) {
            String str1 = "The send time is :" + Calendar.getInstance().getTimeInMillis() + ":\r\n" + str.substring(x, y);
            data[j] = str1;
            x = x + 1048576;
            y = y + 1048576;
            String[] ss = str1.split(":");
            System.out.println(ss[1]);
            //System.out.println(str1);
            writer.write(str1+"\r\n");
        }
        writer.flush();
        writer.close();
    }
}