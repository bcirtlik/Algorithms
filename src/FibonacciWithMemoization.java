public class FibonacciWithMemoization {

    public static int fib(int n,Integer[] memo){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        if(memo[n]==null){
            memo[n]=fib(n-1,memo)+fib(n-2,memo);
        }

        return  memo[n];

    }

    public static void main(String[] args) {
        Integer[] memo=new Integer[100];
        System.out.println(fib(5,memo));
    }
}
