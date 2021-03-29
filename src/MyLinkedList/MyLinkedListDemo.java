package MyLinkedList;

public class MyLinkedListDemo {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add("A");
        list.add("B");
        list.add("C");
//        System.out.println(list.toString());
//        list.add(2,"c");
//        list.add(0,"a");
//        System.out.println(list.toString());
//        list.add(4,"a");
        list.remove(2);
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());


    }
}
