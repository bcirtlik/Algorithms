import java.util.*;

public class ShortestPathBFS {

        public static void printShortestPath(List<List<Integer>> graph,int rowNum,int columnNum){

            int[] rowDirections=new int[]{0,1,-1,0};
            int[] columnDirections=new int[]{-1,0,0,1};

            int sr=0;
            int sc=0;

            int counter=0;

            boolean[][] visited=new boolean[rowNum][columnNum];





            Queue<Integer> rowQueue=new LinkedList();
            Queue<Integer> columnQueue=new LinkedList();

            rowQueue.add(sr);
            columnQueue.add(sc);

            while (rowQueue.size()!=0){

                int dr=rowQueue.poll();
                int dc=columnQueue.poll();

                visited[dr][dc]=true;

                if(graph.get(dr).get(dc)==9){

                    System.out.println(counter);
                }

                for(int i=0;i<4;i++){
                    int ri=dr+rowDirections[i];
                    int ci=dc+columnDirections[i];
                    if(ri>-1 && ri<rowNum && ci>-1 && ci<columnNum) {
                    if(graph.get(ri).get(ci)!=0 && !visited[ri][ci]){

                            rowQueue.add(ri);
                            columnQueue.add(ci);
                            counter++;
                        }
                    }



                }

            }


        }

    public static void main(String[] args) {

            List<List<Integer>> list=new ArrayList<>();
            list.add(Arrays.asList(1,1,0));
            list.add(Arrays.asList(1,0,0));
            list.add(Arrays.asList(1,9,0));
            printShortestPath(list,3,3);
    }
}
