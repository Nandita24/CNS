//Program to implement Leaky BUcket
import java.util.*;

public class LeakyBucket {
	public static void main(String args[])
	{
		System.out.println("Enter no of time intervals\n");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int t[]=new int[n];
		System.out.println("Enter the time internal");
		for(int i=0;i<n;i++)
			t[i]=sc.nextInt();
		System.out.println("Enter i and l\n");
		int i=sc.nextInt();
		int l=sc.nextInt();
		
		int lct=t[0];
		int x=0,y=0;
		
		for(int j=0;j<n;j++)
		{
			y=x-(t[j]-lct);
			if(y>l)
			{
				System.out.println("Non Conforming Packet"+t[j]);
			}
			else
			{
				x=y+i;
			    lct=t[j];
			  System.out.println("Conforming Packet"+t[j]);
			}
		}
			
	}
}
				
	