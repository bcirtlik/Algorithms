package Implementations;

public class BinarySearchThreeImpl {

    private BTSNode leastRightNode;


    public BTSNode find(BTSNode head, int data) {

        if (head == null || head.data == data)
            return head;
        else if (head.data > data) {
            return find(head.right, data);
        } else {
            return find(head.left, data);
        }

    }


    public BTSNode insert(BTSNode head, int data) {
        if (head == null)
            return new BTSNode(data, null, null);
        else if (head.data < data) {
            head.right = insert(head.right, data);
        } else {
            head.left = insert(head.left, data);
        }

        return head;

    }


    public BTSNode delete(BTSNode head, int data) {
        if (head == null)
            return head;

        else if (data < head.data)
            head.left = delete(head.left, data);

        else if (data > head.data)
            head.right = delete(head.right, data);

        else {

            if(head.left==null)
                return head.right;
            else if(head.right==null)
                return head.left;

            head.data=minValue(head.right).data;
            head.right=delete(head.right,head.data);
        }

        return head;
    }

    public BTSNode minValue(BTSNode node){

        while (node.left!=null){
            node=node.left;
        }
        return node;
    }


    public void dfs(BTSNode node) {
        if (node == null)
            return;
        System.out.println(node.data);
        dfs(node.right);
        dfs(node.left);
    }

    public static void main(String[] args) {
        BinarySearchThreeImpl bst = new BinarySearchThreeImpl();
        BTSNode node = bst.insert(null, 3);
        node = bst.insert(node, 2);
        node = bst.insert(node, 6);

        node = bst.delete(node, 2);

        bst.dfs(node);

    }

}


class BTSNode {
    int data;
    BTSNode left;
    BTSNode right;

    public BTSNode(int data, BTSNode left, BTSNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}