import java.io.*;

/**
 *
 * ObjectOutputStream
 * ObjectInputStream
 */

public class PersonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建文件
        File f1 = new File("D:\\JavaSE\\testFile\\Person.del");
        f1.createNewFile();

        //创建对象流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f1));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));

        //创建对象
        Person p1 = new Person("大大丁",30);
        Person p2 = new Person("蓝天",22);
        Person p3 = new Person("地平线",30);

        //序列化写入文件
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);

        //反序列化从文件读取对象
        Person p11 = (Person)ois.readObject();
        Person p22 = (Person)ois.readObject();
        Person p33 = (Person)ois.readObject();
        System.out.println(p11.getName()+"---"+p11.getAge());
        System.out.println(p22.getName()+"---"+p22.getAge());
        System.out.println(p33.getName()+"---"+p33.getAge());


        //关闭数据流
        oos.close();
        ois.close();
    }
}
