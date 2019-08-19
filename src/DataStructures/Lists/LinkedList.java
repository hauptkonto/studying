package DataStructures.Lists;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(int size) {
        Node node = new Node("0");
        head = node;
        tail = node;
        createExapleData(size);
    }

    public LinkedList() {

    }

    public static LinkedList getRandomList(int size) {
        synchronized(LinkedList.class) {
            LinkedList list = new LinkedList();
            int number = (int) (Math.random() * size);
            Node node = new Node("" + number);
            list.setHead(node);
            list.setTail(node);
            for(int i = 0; i < size; i++) {
                number = (int) (Math.random() * size);
                list.add(new Node("" + number));
            }
            return list;
        }
    }

    public void createExapleData(int size) {
        for(int i = 1; i < size; i++) {
            this.add(new Node("" + i));
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    @Override
    public String toString() {
        Node reference = head;
        String str = "";
        while(reference != null) {
            str = str + reference.toString() + ", ";
            reference = reference.getNext();
        }
        str = str.substring(0, str.length() - 2);
        return str;
    }

    public static class Node {
        private Node next;
        private String data;

        public Node() {
        }

        public Node(String data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public boolean isGreaterThan(Node node) {
            int comparison = this.getData().compareTo(node.getData());
            return comparison > 0;
        }

        @Override
        public String toString() {
            return data;
        }
    }
}