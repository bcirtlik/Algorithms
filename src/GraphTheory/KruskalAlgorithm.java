package GraphTheory;

//https://www.hackerrank.com/challenges/kruskalmstrsub/problem

import java.io.*;
import java.util.*;

class Result {


    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int totalWeight=0;
        List<Node> nodes=new ArrayList<>();
        for(int i=0;i<gWeight.size();i++){
            nodes.add(new Node(gFrom.get(i),gTo.get(i),gWeight.get(i)));
        }

        Collections.sort(nodes);


        int arr[]=new int[gNodes+1];

        for(int i=1;i<=gNodes;i++){
            arr[i]=i;
        }


        for(int i=0;i<nodes.size();i++){
            if(allSameGroup(arr)){
                break;
            }
            int to=nodes.get(i).nodeTo;
            int from=nodes.get(i).nodeFrom;
            int weight=nodes.get(i).weight;

            if(arr[to]==arr[from])
                continue;
            else {
                arr=merge(arr, to, from);
                totalWeight += weight;
            }
        }

        return totalWeight;

    }
    public static int[] merge(int arr[],int to,int from){
        int temp=arr[to];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==temp)
                arr[i]=arr[from];
        }
        return arr;
    }


    public static boolean allSameGroup(int arr[]){
        int temp=arr[1];
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=temp){
                return false;
            }
        }
        return true;
    }

}

public class KruskalAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        System.out.println(res);

        bufferedReader.close();
    }
}

class Node implements Comparable<Node>{
    public int nodeTo;
    public int nodeFrom;
    public int weight;

    public Node(int nodeTo,int nodeFrom,int weight){
        this.nodeTo=nodeTo;
        this.nodeFrom=nodeFrom;
        this.weight=weight;
    }

    public int compareTo(Node n){
        return this.weight-n.getWeight();
    }

    public int getWeight(){
        return this.weight;
    }

}
