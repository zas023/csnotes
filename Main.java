import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.println(maxSubString(str));
    }

    //动态规划
    public static int maxSubString(String str){
    	int n=str.length();
    	char[] array=str.toCharArray();
    	int[][] dp=new int[n][n];

    	for(int i=n-1;i>=0;i--){
    		dp[i][i]=1;
    		for (int j=i+1;j<n ;j++ ) {
    			if(array[i]==array[j])
    				dp[i][j]=dp[i+1][j-1]+2;
    			else
    				dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
    		}
    	}
    	return dp[0][n-1];
    }

    public static int max(int a,int b){
    	if(a>=b)
    		return a;
    	return b;
    }
}