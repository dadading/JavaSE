public class MyLinkedListDemo {
    public static void main(String[] args) {
        //新建链表对象
        MyLinkedList mll = new MyLinkedList();


        //测试链表功能
        System.out.println("未插入节点的链表长度是:"+mll.length());
        System.out.print("未插入节点的链表遍历:");
        mll.show();

        mll.tailInsert(1);
        mll.tailInsert(2);
        mll.tailInsert(3);
        mll.tailInsert(99);
        System.out.println("----------");

        System.out.println("尾部插入节点的链表长度是:"+mll.length());
        System.out.print("尾部插入节点的链表遍历:");
        mll.show();

        mll.headInsert(0);
        mll.headInsert(-2);
        mll.headInsert(-3);
        mll.headInsert(-99);
        System.out.println("----------");

        System.out.println("头部插入节点的链表长度是:"+mll.length());
        System.out.print("头部插入节点的链表遍历:");
        mll.show();
        System.out.println("-99元素所在节点index是:"+mll.findIndex(-99));
        System.out.println("99元素所在节点index是:"+mll.findIndex(99));
        System.out.println("0元素所在节点index是:"+mll.findIndex(0));
        System.out.println("-1索引对应的value是:"+mll.findValue(-1));
        System.out.println("0索引对应的value是:"+mll.findValue(0));
        System.out.println("4索引对应的value是:"+mll.findValue(4));
        System.out.println("----------");

        mll.reverseList();
        System.out.println("反转后的链表长度是:"+mll.length());
        System.out.print("反转后的链表遍历:");
        mll.show();
        System.out.println("----------");

        mll.clean();
        System.out.println("清空后的链表长度是:"+mll.length());
        System.out.print("清空后的链表遍历:");
        mll.show();
        System.out.println("----------");


    }
}
