import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 98162 on 2016/7/13.
 * 需求：从.WMV文件中读入批量数据（2.29 GB）
 * 问题：读一段发一段，还是读完再切割了发？
 */
/*
public class FileReaderTask {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("间客2.txt");
        char[] cc = new char[1024*1024*10];
        int hasRead = 0;
        String data[] = new String[10];
        while ((hasRead = fileReader.read(cc))>0){
            String muchData = new String(cc,0,hasRead);
            System.out.println(muchData);
            int x = 0, y = 1024;
            for (int j = 0; j < 10; j++) {
                String str1 = muchData.substring(x, y);
                //int substr = Integer.parseInt(str1);
                data[j] = str1;
                x = x + 1024;
                y = y + 1024;
                System.out.println(str1);
            }
        }
    }
}
*/