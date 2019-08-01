import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l1= Arrays.asList(1,1,0);
        List<Integer> l2=Arrays.asList(1,1,1);
        List<Integer> l3=Arrays.asList(9,0,1);
        list.add(l1);
        list.add(l2);
        list.add(l3);

        ShortestPathBFS shortestPathBFS=new ShortestPathBFS(list,3,3);

    }

}
