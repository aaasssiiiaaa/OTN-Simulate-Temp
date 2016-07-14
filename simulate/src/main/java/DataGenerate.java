import java.util.Calendar;

/**
 * Created by asia on 2016/7/3.
 * 需求：生成随机数据，并按长度切割
 */
public class DataGenerate {
    static final String pool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int poolSize = pool.length();
    String data[] = new String[15];
    public DataGenerate() {
    }
    public String[] daGenrate() {
        StringBuffer str = new StringBuffer();
        long randomDataCount = 0 ;
        //while (randomDataCount < 10485760){
        while (randomDataCount < 15728640){
            str.append(pool.charAt((int) (Math.random()*poolSize)));
            randomDataCount++;
        }
        //切割字符串
        int x = 0, y =1048576 ;
        for (int j = 0; j < 15; j++) {
            String str1 = "The send time is :"+
                    Calendar.getInstance().getTimeInMillis() +
                    ":[]\r\n"+str.substring(x, y);
            data[j] = str1;
            x = x + 1048576;
            y = y + 1048576;
            //System.out.println(str1);
        }
        return data;
    }
}

