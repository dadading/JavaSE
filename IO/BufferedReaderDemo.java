import java.io.*;

/**
 * 高效字符流
 * BufferedReader 高效字符输入流
 * BufferedWriter 高效字符输出流
 */

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\br.del");
        File f2 = new File("D:\\JavaSE\\testFile\\bw.del");
        f1.createNewFile();
        f2.createNewFile();

        //创建数据流
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));

        //测试
        //1-单个字符输出界面
//        int a= 0;
//        while((a=br.read())!=-1){
//            System.out.print((char)a);
//        }
        System.out.println("----------");

        //2-字符数组输出界面
//        char[] ch = new char[1024];
//        int len =0;
//        while((len=br.read(ch))!=-1){
//            System.out.print(new String(ch));
//        }
        System.out.println("----------");

        //3-单个字符复制文件
//        int a= 0;
//        while((a=br.read())!=-1){
//            bw.write(a);
//        }
        System.out.println("----------");

        //4-字符数组复制文件
//        char[] ch = new char[1024];
//        int len=0;
//        while((len=br.read(ch))!=-1){
//            bw.write(ch,0,len);
//        }
        System.out.println("----------");

        //5-按行复制文件
        String line = null;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }
        System.out.println("----------");


        //关闭数据流
        br.close();
        bw.close();
    }
}
