package Implementations;

public class QueueImpl {
    LinkedListImpl linkedList=new LinkedListImpl();

    public int poll(){
        return linkedList.removeAtTail().data;
    }

    public void add(int x){
        linkedList.addAtHead(x);
    }

    public static void main(String[] args) {
        QueueImpl queue=new QueueImpl();
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
