public class FibonacciWithBottomUp {

    public static int fib(int n){
        Integer[] arr=new Integer[n+1];
        for(int i=1;i<=n;i++){
            if(i==1)
                arr[i]=1;
            else if(i==2)
                arr[i]=1;
            else
             arr[i]=arr[i-1]+arr[i-2];
        }

       return arr[n];
    }


    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
