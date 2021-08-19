import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        char[] ch = new char[100];
        ch[3] = '丁';
        ch[4] = '冠';
        ch[5] = '一';
         String s1 = new String(ch);
        System.out.println(s1.substring(3,6));
        System.out.println(s1.length());
    }
}
