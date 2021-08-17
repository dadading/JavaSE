import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.del");

        FileOutputStream fos = new FileOutputStream("2.del");

//        int a =0;
//        while((a=fis.read())!=-1){
//            System.out.print((char)a);
//        }

        byte[] a=new byte[1024];
        int len=0;
        while((len=fis.read(a))!=-1){
            System.out.print(Arrays.toString(a));
        }

        //按字节传输
//        int a = 0;
//        while ((a = fis.read()) != -1) {
//            fos.write(a);
//        }

        //按字节数组传输
//        byte[] by = new byte[1024];
//        int len =0;
//        while((len=fis.read(by))!=-1){
//            fos.write(by,0,len);
//        }
    }
}
