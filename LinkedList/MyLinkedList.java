public class MyLinkedList {
    //定义头部节点
    Node head;

    //定义尾部节点
    Node tail;

    public MyLinkedList() {
        //初始化头部节点/尾部节点都指空
        head = null;
        tail = null;
    }

    private class Node {
        //链表数据载体
        int value;

        //单向指针
        Node next;
    }

    //清空链表
    public void clean() {
        //只要把头部节点的指向指空即可
        head = null;
    }

    //返回链表长度
    public int length() {
        //定义节点指向头部节点
        Node node = head;

        //若头部节点为空,则链表为空
        if (node == null) {
            return 0;
        }

        //若节点不为空,则循环查看后面节点是否为空,并累加
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    //链表遍历
    public void show() {
        //定义节点指向头部节点
        Node node = head;

        //若头部节点是空则链表为空
        if (node == null) {
            System.out.println("链表为空");
        }

        //若节点不为空,则循环打印后续节点
        while (node != null) {
            //若是最后一个节点打印后跳出循环
            if (node.next == null) {
                System.out.println(node.value);
                break;
            }
            //若不是最后一个节点打印后,指针指向下一节点
            else {
                System.out.print(node.value + "-->");
                node = node.next;
            }
        }
    }

    //在尾部添加节点
    public void tailInsert(int value) {
        //创建新增的节点,并给数据载体赋值
        Node node = new Node();
        node.value = value;

        //若链表为空,则first和tail节点都指向新建的节点
        if (head == null) {
            head = node;
            tail = node;
        }
        //若链表不为空,则在tail节点下游添加,添加后需要移动tail节点指向
        else {
            tail.next = node;
            tail = node;
        }
    }

    //在头部添加
    public void headInsert(int value) {
        //创建新增的节点,并给数据载体赋值
        Node node = new Node();
        node.value = value;

        //若链表为空,则first和tail节点都指向新建的节点
        if (head == null) {
            head = node;
            tail = node;
        }
        //若链表不为空,则在first节点上游添加,添加后需要移动first节点指向
        else {
            node.next = head;
            head = node;
        }
    }

    //查找value对应的index
    public int findIndex(int value) {
        //定义节点指向头部节点
        Node node = head;

        //定义初始化index
        int index = 0;

        if (node == null) {
            return -1;
        }

        while (node != null) {
            //若当前节点数据等于传入的数据则跳出循环,否则指向下一节点,index++
            if (node.value == value) {
                break;
            } else {
                node = node.next;
                index++;
            }

        }

        return index;
    }

    //查找index对应的value
    public int findValue(int index) {
        //若index不合法直接返回-1
        if (index < 0 || index >= length()) {
            System.out.println("您输入的index非法,请重新输入!");
            return -1;
        }

        //定义节点指向头部节点
        Node node = head;

        while (true) {
            //若index递减为0则跳出循环
            if (index == 0) {
                break;
            } else {
                node = node.next;
                index--;
            }
        }

        return node.value;
    }

    //链表反转
    public void reverseList() {
        //节点超过2个才需要反转
        if (head.next != null) {
            //定义三个指针
            Node nowNode = head;
            Node nextNode = null;
            Node preNode = null;

            //先把尾部节点切换
            tail = nowNode;

            while (nowNode != null) {
                nextNode = nowNode.next;

                nowNode.next = preNode;

                preNode = nowNode;

                nowNode = nextNode;
            }

            //最后把头部节点切换
            head = preNode;
        }
    }
}
