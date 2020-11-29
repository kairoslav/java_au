package iterator;
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> obj = new MyLinkedList<>();
        obj.addAtHead(7);
        obj.addAtTail(0);
        obj.deleteAtIndex(1);
        obj.addAtTail(5);
        obj.addAtIndex(1, 1);
        obj.addAtIndex(2, 6);
        obj.deleteAtIndex(2);
        obj.deleteAtIndex(1);
        for (int i: obj) {
            System.out.println(i);
        }
        System.out.println();


        MyLinkedList<String> obj2 = new MyLinkedList<>();
        obj2.addAtTail("1");
        obj2.addAtTail("2");
        obj2.addAtTail("3");
        obj2.addAtTail("4");
        obj2.addAtTail("5");
        obj2.addAtTail("6");
        obj2.addAtTail("7");
        for (String i : obj2) {
            System.out.println(i);
        }
    }
}
