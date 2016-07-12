/**
 * Created by asia on 2016/7/3.
 * 需求：生成随机数据，并按长度切割
 */
public class DataGenerate {
    String data[] = new String[6];
    public DataGenerate() {
    }
    public String[] daGenrate() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            str.append((int) (1 + Math.random() * 10));
        }
        //切割字符串
        int x = 0, y = 5;
        for (int j = 0; j < 6; j++) {
            String str1 = str.substring(x, y);
            //int substr = Integer.parseInt(str1);
            data[j] = str1;
            x = x + 5;
            y = y + 5;
            System.out.println(str1);
        }return data;
    }
}

