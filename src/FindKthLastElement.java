import Implementations.LinkedListImpl;
import Implementations.Node;

import java.util.LinkedList;

public class FindKthLastElement {

    //First Method
    public int findRecursive(Node node, int k){
        if(node==null)
            return 0;

        int index=findRecursive(node.getLink(),k)+1;

        if(k==index)
            System.out.println(node.getData());

        return index;

    }

    //Second Method
    public void findNonRecursive(Node node,int k){

        Node n1=node;
        Node n2=node;

        for(int i=0;i<k;i++){
            if(n1!=null){
                n1=n1.getLink();
            }else
            {
                System.out.println("Out of Bounds");
                return;
            }
        }

       while (n1!=null){
           n1=n1.getLink();
           n2=n2.getLink();
       }
       System.out.println(n2.getData());
    }

    public static void main(String[] args) {
        FindKthLastElement findKthLastElement=new FindKthLastElement();
        LinkedListImpl linkedList=new LinkedListImpl();
        linkedList.addAtHead(33);
        linkedList.addAtHead(2);
        linkedList.addAtHead(43);
        linkedList.addAtHead(12);
        linkedList.addAtHead(11);
        //findKthLastElement.findNonRecursive(linkedList.getHead(),3);
        //findKthLastElement.findRecursive(linkedList.getHead(),3);
    }


}
