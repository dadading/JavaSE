import java.io.*;
import java.util.Arrays;

/**
 * FileInputStream 基础字节输入流
 * FileOutputStream 基础字节输出流
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\fis.del");
        File f2 = new File("D:\\JavaSE\\testFile\\fos.del");
        f1.createNewFile();
        f2.createNewFile();

        //创建基础字节输入流
        FileInputStream fis = new FileInputStream(f1);

        //创建基础字节输出流
        FileOutputStream fos = new FileOutputStream(f2);

        //测试
        //1-按单个字节输出在屏幕
//        int a = 0;
//        while((a=fis.read())!=-1){
//            System.out.print((char)a);
//        }
        System.out.println("----------");

        //2-按字节数组输出在屏幕
//        byte[] by = new byte[1024];
//        int len;
//        while((len=fis.read(by))!=-1){
//            //System.out.println(Arrays.toString(by));
//            for(int i=0;i<len;i++){
//                System.out.print((char)by[i]);
//            }
//            System.out.println();
//        }
        System.out.println("----------");

        //3-按单个字节复制文件
//        int a = 0;
//        while((a=fis.read())!=-1){
//            fos.write(a);
//        }
        System.out.println("----------");

        //4-按字节数组写入文件
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = fis.read(by)) != -1) {
            fos.write(by, 0, len);
        }
        System.out.println("----------");


        //关闭数据流
        fis.close();
        fos.close();
    }
}
