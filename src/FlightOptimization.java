import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FlightOptimization
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        List<List<Integer>> finalList=new ArrayList<>();

        int forwardSize=forwardRouteList.size();
        int returnSize=returnRouteList.size();

        int opt=maxTravelDist;


        for(int i=0;i<forwardRouteList.size();i++){
            int total=forwardRouteList.get(i).get(1)+returnRouteList.get(returnSize-1).get(1);
            int diff=maxTravelDist-total;

            if(opt>java.lang.Math.abs(diff)){
                finalList.clear();
                opt=diff;
            }

            if(diff==0 || diff<0 ){
                if(opt==diff){
                    List<Integer> list=Arrays.asList(i+1,returnSize);
                    finalList.add(list);
                }
                break;
            }
        }



        for(int i=0;i<returnRouteList.size();i++){
            int total=returnRouteList.get(i).get(1)+forwardRouteList.get(forwardSize-1).get(1);
            int diff=maxTravelDist-total;

            if(opt>java.lang.Math.abs(diff)){
                finalList.clear();
                opt=diff;
            }

            if(diff==0 || diff<0 ){
                if(opt==diff){
                    List<Integer> list=Arrays.asList(forwardSize,i+1);
                    finalList.add(list);
                }
                break;
            }
        }

        return finalList;

    }




    // METHOD SIGNATURE ENDS
}