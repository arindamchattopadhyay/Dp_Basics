//Count the number of subsets with their  difference of the sums equal to diff.

import java.util.*;
public class Subsets_With_Min_Diff
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();sum+=a[i];
		}
		int diff=sc.nextInt();
		sum=(sum+diff)/2;
		int c=countDifference(a,sum);
		System.out.println(c);

	}
	static int countDifference(int a[],int sum)
	{
		int dp[][]=new int[a.length+1][sum+1];
		for(int i=0;i<=a.length;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				if(i==0&&j==0)
					dp[i][j]=1;
				else if(i==0)
					dp[i][j]=0;
				else if(j==0)
					dp[i][j]=1;
				else if(a[i-1]<=j)
					dp[i][j]=dp[i-1][j-a[i-1]]+dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[a.length][sum];
	}
}