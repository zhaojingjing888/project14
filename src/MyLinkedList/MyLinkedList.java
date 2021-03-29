package MyLinkedList;

import javafx.scene.control.TableColumn;

import java.util.List;

public class MyLinkedList {
    //链表类型，属性：头节点、尾节点

    public Node head;
    public Node last;
    public int size;

    public MyLinkedList(){
        head = null;
        last = null;
        size = 0;
    }
    private static void testList(MyLinkedList list){
         int count1 = 0;
         Node cur1 =list.head;
         while(cur1 != null){
             cur1 = cur1.next;
             count1++;
         }
         int count2 = 0;
         Node cur2 = list.last;
         while(cur2 != null){
             cur2 = cur2.prev;
             count2++;
         }
         if(count1 != count2){
             throw  new RuntimeException("破对象");
         }
         if(count1 != list.size || count2 != list.size){
             throw new RuntimeException("破对象");
         }
         if(list.head == null){
             if(list.last != null)
             {
                 throw new RuntimeException("破对象");
             }
         }
         if(list.head != null){
             Node last = list.head;
             while(last.next != null){
                 last = last.next;
             }
             Node head = list.last;
             while(head.prev != null){
                 head = head.prev;
             }
             if(last != list.last || head != list.head){
                 throw new RuntimeException("破对象");
             }
         }

    }
    public boolean add(String e){
        Node node = new Node(e);

//        if(head == null){
//            head   = node;
//        }else{
//            Node last = head;
//            while(last.next != null){
//
//                last = last.next;
//            }
//            last.next = node;
//        }//时间复杂度O(n)
        if(head == null){
            head = last = node;
        }else{
            node.prev = last;
            last.next = node;
            last = node;
        }//牺牲一点空间，换取时间复杂度为O（1）
        size++;
        return true;
    }

    public void add(int index,String e){
        if(size() == 0){
            Node node = new Node(e);
            head = last = node;
        }
        if(index <0 || index > size()){
            throw new RuntimeException("NPE");
        }
        Node prev = head;
        if(index == 0){
            Node node = new Node(e);
            node.next = prev;
            prev.prev = node;
            head = node;
        }
        else if(index == size()){
            add(e);
        }
        else{
            Node node = new Node(e);
            for(int i = 0;i<index - 1;i++){
                prev = prev.next;
            }
            Node next = prev.next;
            prev.next = node;
            next.prev = node;
            node.next = next;
            node.prev = prev;

        }
        size++;

    }
    public String remove(int index){
        if (index < 0 || index > size()) {

            throw new RuntimeException("NPE");
        }
        String e;
        if(size == 1){
            e = head.val;
            head  = last= null;

        }
        else if(index == 0){
            e = head.val;
            head = head.next;

        }
        else if(index == size() - 1){
            e = last.val;
            last = last.prev;
            last.next = null;

        }
        else{

            Node del = head;
            e = del.val;
            for(int i = 0;i<index;i++){
               del = del.next;
            }
            Node prev = del.prev;
            Node next = del.next;
            prev.next = next;
            next.prev = prev;

        }
        size--;
        return e;
    }
    public boolean contains(String e){

        for(Node cur = head;cur!= null;cur = cur.next){
            if(cur.val.equals(e)){
                return true;
            }
        }
        return false;
    }
    public int indexof(String e){
        int count  = 0;
        for(Node cur = head;cur!= null;cur = cur.next){
            if(cur.val.equals(e)){
                return count;
            }
            count++;

        }
        return -1;
    }
    public int lastindexof(String e){
        int count = size();
        for(Node cur = last;cur != null;cur = cur.prev){
            if(cur.val.equals(e)){
                return count -1;
            }
            count--;
        }
        return -1;
    }
    public String get(int index){
        if(index <0 || index >size){
            throw new ArithmeticException();
        }
        Node cur = head;
        for (int i = 0;i < index-1;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    public String set(int index,String e){
        if(index <0 || index >size){
            throw new ArithmeticException();
        }
        Node cur = head;

        for (int i = 0;i < index-1;i++){
            cur = cur.next;
        }
        String oldE = cur.val;
        cur.val = e;
        return oldE;

    }
    public int size(){
        return size;
//        int count = 0;
//        Node cur = head;
//        while(cur != null){
//            cur = cur.next;
//            count++;
//        }
//        return count;
    }
    public boolean isEmpty(){
//        if(size == 0){
//            return true;
//        }
//        return false;
        return size == 0;
    }
    public void clear(){
        head = last = null;
        size = 0;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        Node cur = head;
        while(cur != null){
            s.append(cur.val).append(",");
            cur = cur.next;
        }
        s.append("]");
        return s.toString();//String反复创建临时变量，导致效率不高,所以使用StringBuilder
    }
}
