package iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T temp = current.val;
                current = current.next;
                return temp;
            }
        };
    }

    private class Node {
        T val;
        Node next;
        Node prev;
        public Node(T val) {
            this.val = val;
        }
    }
    private Node head;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public T get(int index) throws IndexOutOfBoundsException{
        if (index >= size) throw new IndexOutOfBoundsException();
        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(T val) {
        Node pointer = head;
        head = new Node(val);
        head.next = pointer;
        if (pointer != null) {
            pointer.prev = head;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(T val) {
        Node tail = head;
        if (size == 0) {
            addAtHead(val);
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        Node temp = tail;
        tail.next = new Node(val);
        tail = tail.next;
        tail.prev = temp;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, T val) {
        if (index == 0) {
            addAtHead(val);
        }
        else if (index == size) {
            addAtTail(val);
        }
        else if (index < size) {
            Node pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            Node prev = pointer.prev;
            Node temp = new Node(val);

            prev.next = temp;
            temp.prev = prev;
            temp.next = pointer;
            pointer.prev = temp;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (index == 0) {
            head = head.next;
            size--;
        }
        else if (index == size - 1) {
            Node pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            Node prev = pointer.prev;
            prev.next = null;
            size--;
        }
        else {
            Node pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            Node prev = pointer.prev;
            Node next = pointer.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
    }
}
