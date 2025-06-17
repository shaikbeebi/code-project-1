import java.util.*;
public class Fibonacci{
	static int fib(int n, int[] dp) {
		if (n <= 1) return n;
		if (dp[n] != -1) return dp[n];
		return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of series:");
		int n=sc.nextInt();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(fib(n, dp));
		for(int i=0;i<n;i++)
			System.out.print(dp[i]);
	} 
}