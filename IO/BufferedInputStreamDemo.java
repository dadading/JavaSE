import java.io.*;

/**
 * BufferedInputStream 高效字节输入流
 * BufferedOutputStream 高效字节输出流
 */

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\bis.del");
        File f2 = new File("D:\\JavaSE\\testFile\\bos.del");
        f1.createNewFile();
        f2.createNewFile();

        //创建数据流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));

        //测试
        //1-单个字节输出屏幕
//        int a = 0;
//        while((a=bis.read())!=-1){
//            System.out.print((char)a);
//        }
        System.out.println("----------");

        //2-字节数组输出屏幕
//        byte[] by = new byte[1024];
//        int len=0;
//        while((len=bis.read(by))!=-1){
//            for(int i=0;i<len;i++){
//                System.out.print((char)by[i]);
//            }
//            System.out.println();
//        }
        System.out.println("----------");

        //3-单个字节复制文件
//        int a=0;
//        while((a=bis.read())!=-1){
//            bos.write(a);
//        }
        System.out.println("----------");

        //4-字节数组复制文件
        byte[] by = new byte[1024];
        int len = 0;
        while ((len = bis.read(by)) != -1) {
            bos.write(by, 0, len);
        }
        System.out.println("----------");

        //关闭数据流
        bis.close();
        bos.close();
    }
}
