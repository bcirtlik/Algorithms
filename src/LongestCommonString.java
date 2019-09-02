

public class LongestCommonString {

    public static int lcs(char[] st1,char[] st2,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(st1[m-1]==st2[n-1]){
            return 1 + lcs(st1,st2,m-1,n-1);
        }
        else{
            return max(lcs(st1,st2,m-1,n),lcs(st1,st2,m,n-1));
        }
    }


    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static void main(String[] args) {
        String s1="ELIF";
        String s2="BURCU";

        char[]ch1=s1.toCharArray();
        char [] ch2=s2.toCharArray();

        System.out.println(lcs(ch1,ch2,ch1.length,ch2.length));
    }


}
