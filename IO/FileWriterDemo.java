import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字符简化流(和转化流相比,入参是文件即可)
 * FileReader 基础字符输入流
 * FileWriter 基础字符输出流
 */

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\fr.del");
        File f2 = new File("D:\\JavaSE\\testFile\\fw.del");
        f1.createNewFile();
        f2.createNewFile();

        //创建数据流
        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);

        //测试
        //1-单个字符输出界面
//        int a = 0;
//        while((a=fr.read())!=-1){
//            System.out.print((char)a);
//        }
        System.out.println("----------");

        //2-字符数组输出界面
//        char[] ch = new char[1024];
//        int len=0;
//        while((len=fr.read(ch))!=-1){
//            System.out.println(new String(ch));
//        }
        System.out.println("----------");

        //3-单个字符复制
//        int a =0;
//        while((a=fr.read())!=-1){
//            fw.write(a);
//        }
        System.out.println("----------");

        //4-字符数组复制
        char[] ch  = new char[1024];
        int len =0;
        while((len=fr.read(ch))!=-1){
            fw.write(ch,0,len);
        }
        System.out.println("----------");

        //关闭数据流
        fr.close();
        fw.close();

    }
}
