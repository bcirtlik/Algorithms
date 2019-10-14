package Implementations;

import java.util.HashMap;

public class TrieImpl {

    public static TrieNode root=new TrieNode() ;

    public static void insert(char[] st, int index, TrieNode node) {
        if (st.length == index) {
            node.isCompleteWord=true;
            return;
        }
        if(node.children.get(st[index])==null) {
            TrieNode newNode = new TrieNode();
            node.children.put(st[index], newNode);
            insert(st, index + 1, newNode);
        }else{
            insert(st,index+1,node.children.get(st[index]));
        }

    }

    public static void print(TrieNode node){
        if(node==null || node.children.size()==0){
            return;
        }
        if(node.isCompleteWord){
            node.isCompleteWord=false;
            System.out.println(" ");
            print(root);
            return;
        }
        for(char key:node.children.keySet()){
            System.out.print(key);
            print(node.children.get(key));
            System.out.println(" ");
        }

    }

    public static void main(String... args){

        String st1="burcu";
        String st2="emre";

        insert( st1.toCharArray(),0,root);
        insert( st2.toCharArray(),0,root);
        print(root);

    }

}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isCompleteWord;

    public TrieNode() {
    }


}