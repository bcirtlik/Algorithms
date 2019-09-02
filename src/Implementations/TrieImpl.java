package Implementations;

import java.util.HashMap;

public class TrieImpl {


    public static TrieNode insert(char[] st, int index, TrieNode node) {
        if (st.length == index) {
            node.setCompleteWord(true);
            return node;
        }
        TrieNode newNode = new TrieNode(false);
        node.getChildren().put(st[index], newNode);
        insert(st, index + 1, newNode);
        return node;
    }

    public static void print(TrieNode node){
        if(node.getChildren().size()>0){
            node.getChildren().keySet().stream().forEach(f->System.out.print(f));
            return;
        }
       node.getChildren().values().stream().forEach(f->print(f));
    }

    public static void main(String... args){
        TrieNode trieNode=new TrieNode(false);
        String st1="burcu";

    }

}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isCompleteWord;

    public TrieNode(boolean isCompleteWord) {
        this.isCompleteWord = isCompleteWord();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }
}