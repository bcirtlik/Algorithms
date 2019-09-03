package Implementations;

import java.util.HashMap;

public class TrieImpl {

    public static TrieNode root=new TrieNode() ;

    public static void insert(char[] st, int index, TrieNode node) {
        if (st.length == index) {
            node.isCompleteWord=true;
            return ;
        }
        TrieNode newNode = new TrieNode();
        node.children.put(st[index], newNode);
        insert(st, index + 1, newNode);

    }

    public static void print(TrieNode node){
        if(node.isCompleteWord)
            return;
        if(node.children.size()>0){
            node.children.keySet().stream().forEach(f->System.out.print(f));
            node.children.values().stream().forEach(f->print(f));

        }

    }

    public static void main(String... args){

        String st1="burcu bu";

        insert( st1.toCharArray(),0,root);
        print(root);

    }

}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isCompleteWord;

    public TrieNode() {
    }


}