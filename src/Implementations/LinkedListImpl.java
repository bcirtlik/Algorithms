package Implementations;

public class LinkedListImpl {

    Node head;
    Node tail;


    public Node addAtHead(int data) {
        if (head == null) {
            head = tail = new Node(data, null);
        } else {
            head = new Node(data, head);
        }

        return head;
    }

    public Node addAtTail(int data) {
        if (head == null) {
            head = tail = new Node(data, null);
        } else {
            tail.link = new Node(data, null);
            tail = tail.link;
        }
        return head;
    }

    public Node removeAtTail() {
        Node last = tail;
        Node node=head;

        while (node!=null){
            if (node.link!=null && node.link.equals(tail)){
                tail=node;
            }
            node=node.link;
        }


        return last;
    }

    public Node removeAtHead() {
        Node first = head;
        head = head.link;
        return first;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.link;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addAtHead(3);
        linkedList.addAtHead(5);
        linkedList.removeAtHead();
        linkedList.addAtTail(4);
        linkedList.removeAtTail();
        linkedList.print();
    }
}





