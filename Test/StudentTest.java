import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentTest {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("丁冠一",30);

        //创建数据写入流
        File f1 = new File("1.del");
        f1.createNewFile();

        //FileOutputStream fos = new FileOutputStream(new OutputStream("1.del"));

    }
}
