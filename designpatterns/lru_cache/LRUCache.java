package lru_cache;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;

class LRUCache<KEY, VAL> {
    class MyLinkedList {

        private class ListNode {
            ListNode next;
            ListNode prev;
            VAL val;

            ListNode() {
            }

            ListNode(VAL val, ListNode next, ListNode prev) {
                this.val = val;
                this.next = next;
                this.prev = prev;
            }
        }

        ListNode head = new ListNode();
        ListNode tail = new ListNode();

        int size;

        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public VAL get(int index) {
            if (index >= size || index < 0) {
                return null;
            }
            return getNode(index).val;
        }

        public void addAtHead(VAL val) {
            addNewNodeAfter(head, val);
        }

        public void addAtTail(VAL val) {
            addNewNodeBefore(tail, val);
        }

        public void addAtIndex(int index, VAL val) {
            if (index == 0) {
                addAtHead(val);
                return ;
            }
            else if (index == size) {
                addAtTail(val);
                return ;
            }
            else if (index < 0 || index > size) {
                return ;
            }

            addNewNodeBefore(getNode(index), val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return ;
            }

            var current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }

        private void deleteNode(ListNode node) {
            if (node == null) return ;
            // в настоящей реализации двойного списка нет проблем с null
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        private ListNode getNode(int index) {
            var current = (ListNode)null;

            if (index < size / 2) {
                current = head.next;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            }
            else {
                current = tail.prev;
                for (int i = 0; i < size - index - 1; i++) {
                    current = current.prev;
                }
            }

            return current;
        }

        private void addNewNodeAfter(ListNode node, VAL val) {
            var newNode = new ListNode(val, node.next, node);

            node.next.prev = newNode;
            node.next = newNode;

            size++;
        }

        private void addNewNodeBefore(ListNode node, VAL val) {
            var newNode = new ListNode(val, node, node.prev);

            node.prev.next = newNode;
            node.prev = newNode;

            size++;
        }
    }

    private final int capacity;
    private final MyLinkedList linkedList;
    private final Map<KEY, MyLinkedList.ListNode> keyNodeMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedList = new MyLinkedList();
        keyNodeMap = new HashMap<>();
    }

    private void moveToHead(MyLinkedList.ListNode node) {
        linkedList.addAtHead(node.val);
        linkedList.deleteNode(node);
    }

    public VAL get(KEY key) {
        if (keyNodeMap.containsKey(key)) {
            MyLinkedList.ListNode node = keyNodeMap.get(key);
            moveToHead(node);
            keyNodeMap.replace(key, linkedList.getNode(0));

            return node.val;
        }
        return null;
    }

    public void put(KEY key, VAL value) {
        if (keyNodeMap.containsKey(key)) {
            MyLinkedList.ListNode node = keyNodeMap.get(key);
            linkedList.addAtHead(value);
            linkedList.deleteNode(node);
            keyNodeMap.replace(key, linkedList.getNode(0));
        }
        else {
            if (linkedList.size < capacity) {
                linkedList.addAtHead(value);
                keyNodeMap.put(key, linkedList.getNode(0));
            }
            else {
                var deadNode = linkedList.tail.prev;
                linkedList.deleteNode(deadNode);

                linkedList.addAtHead(value);
                keyNodeMap.put(key, linkedList.head.next);

                for (KEY mapKey :keyNodeMap.keySet()) {
                    if (keyNodeMap.get(mapKey) == deadNode) {
                        keyNodeMap.remove(mapKey);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}

