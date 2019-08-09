import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class OrderAlgorithm
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> prioritizedOrders(int numOrders, List<String> orderList)
    {

        Comparator<String> orderComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s1MetaData=findMetaData(s1);
                String s2MetaData=findMetaData(s2);

                if(s1MetaData.equals(s2MetaData)){
                    return s1.compareTo(s2);
                }
                else{
                    return s1MetaData.compareTo(s2MetaData);
                }
            }
        };

        PriorityQueue<String> orderPriorityQueue = new PriorityQueue<>(orderComparator);


        List<String> nonPrimes=new ArrayList<>();

        List<String> finalOrder=new ArrayList<>();

        for(String order:orderList){

            if(!isPrime(order)){
                nonPrimes.add(order);
            }
            else{
                orderPriorityQueue.add(order);
            }
        }

        while(orderPriorityQueue.size()!=0){

            finalOrder.add(orderPriorityQueue.poll());
        }
        finalOrder.addAll(nonPrimes);
        return finalOrder;


    }



    public String findMetaData(String st){

        int firstSpaceIndex=st.indexOf(' ');

        return st.substring(firstSpaceIndex+1,st.length());

    }


    public boolean isPrime(String st){

        String metadata=findMetaData(st);

        char[] chars= metadata.toCharArray();

        for(char c: chars){
            if(((int)c)>96 && ((int)c)<123)
                return true;
        }

        return false;
    }
}