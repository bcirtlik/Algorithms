package Implementations;

public class Node {
    int data;
    Node link;

    public Node(int data,Node link){
        this.link=link;
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
