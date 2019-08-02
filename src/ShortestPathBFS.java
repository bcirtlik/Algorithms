
import java.util.*;

public class ShortestPathBFS {
    int vertexNum;
    int rowNum;
    int columnNum;

    public  ShortestPathBFS(List<List<Integer>> field,int rowNum,int columNum) {
        this.vertexNum=rowNum*columNum;
        this.rowNum=rowNum;
        this.columnNum=columNum;
        Queue<HashMap<String,Integer>> queue=new LinkedList();
        int[][] dist=new int[rowNum][columNum];


        for (int[] row: dist) {
            Arrays.fill(row, -1);
        }


        int i=0;
        int j=0;
        int start=field.get(i).get(j);

        HashMap map=new HashMap();
        map.put("i",i);
        map.put("j",j);
        queue.add(map);

        dist[i][j]=0;

        while (queue.size()!=0){

            HashMap m=queue.poll();
            i= (int) m.get("i");
            j= (int) m.get("j");

            if(field.get(i).get(j)==9){
                break;
            }
            if(i<rowNum-1 && (field.get(i+1).get(j)==1 ||  field.get(i+1).get(j)==9) && dist[i+1][j]==-1){
                dist[i+1][j]=dist[i][j]+1;
                HashMap m1=new HashMap();
                m1.put("i",i+1);
                m1.put("j",j);
                queue.add(m1);
            }

            if(i>0 && (field.get(i-1).get(j)==1 || field.get(i-1).get(j)==9) && dist[i-1][j]==-1){
                dist[i-1][j]=dist[i][j]+1;
                HashMap m2=new HashMap();
                m2.put("i",i-1);
                m2.put("j",j);
                queue.add(m2);
            }

            if(j<columNum-1 && (field.get(i).get(j+1)==1 || field.get(i).get(j+1)==9 ) && dist[i][j+1]==-1){
                dist[i][j+1]=dist[i][j]+1;
                HashMap m3=new HashMap();
                m3.put("i",i);
                m3.put("j",j+1);
                queue.add(m3);
            }

            if(j>0 && (field.get(i).get(j-1)==1 || field.get(i).get(j-1)==9) && dist[i][j-1]==-1){
                dist[i][j-1]=dist[i][j]+1;
                HashMap m4=new HashMap();
                m4.put("i",i);
                m4.put("j",j-1);
                queue.add(m4);
            }
        }

        if(field.get(i).get(j)!=9){
           System.out.println("No Path");
        }else{
            int max=0;
            if(i<rowNum-1 &&  dist[i+1][j]>max){
              max=dist[i+1][j];
            }

            if(i>0 && dist[i-1][j]>max){
                max=dist[i-1][j];
            }

            if(j<columNum-1  && dist[i][j+1]>max){
                max=dist[i][j+1];
            }

            if(j>0 &&  dist[i][j-1]>max){
               max=dist[i][j-1];
            }

            System.out.println("Path Number: "+(max+1));

        }




    }




}
