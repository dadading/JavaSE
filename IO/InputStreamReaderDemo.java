import java.io.*;

/**
 * 转化流(必须新建字节流作为入参)
 * InputStreamReader 字节转化输入流
 * OutputStreamWriter 字节转化输出流
 */

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\isr.del");
        File f2 = new File("D:\\JavaSE\\testFile\\osw.del");
        f1.createNewFile();
        f2.createNewFile();

        //创建数据流
        InputStreamReader isr = new InputStreamReader(new FileInputStream(f1));
        OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(f2));

        //测试
        //1-单个字符输出屏幕
//        int a= 0;
//        while((a=isr.read())!=-1){
//            System.out.print((char)a);
//        }
        System.out.println("----------");

        //2-字符数组输出屏幕
//        char[] ch = new char[1024];
//        int len =0;
//        while((len=isr.read(ch))!=-1){
//            System.out.println(new String(ch));
//        }
        System.out.println("----------");

        //3-单个字符复制
//        int a =0;
//        while((a=isr.read())!=-1){
//            osw.write(a);
//        }
        System.out.println("----------");

        //4-字符数组复制
//        char[] ch = new char[1024];
//        int len =0;
//        while((len=isr.read(ch))!=-1){
//            osw.write(ch,0,len);
//        }
        System.out.println("----------");

        //关闭数据流
        isr.close();
        osw.close();
    }
}
