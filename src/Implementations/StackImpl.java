package Implementations;

public class StackImpl {

        LinkedListImpl linkedList=new LinkedListImpl();

        public void push(int x){
            linkedList.addAtHead(x);
        }

        public int  pop(){
            return linkedList.removeAtHead().data;
        }

        public int peek(){
            return  linkedList.getHead().data;
        }

    public static void main(String[] args) {
        StackImpl stack=new StackImpl();
        stack.push(2);
        stack.push(3);
        stack.peek();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}


