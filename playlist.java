import java.util.*;
import java.lang.*;
import java.io.*;

class Pair implements Comparable<Pair>{
	
	int len;
	int beauty;
	Pair(int len, int beauty){
		this.len=len;
		this.beauty=beauty;
	}
	
	public int compareTo(Pair obj){
		return this.beauty-obj.beauty;
	}
	
}

public class Main{
	public static long func(Pair[] arr, int n, int k){
		
		long max=Long.MIN_VALUE;
		Arrays.sort(arr);
		long sum[]=new long[n];
		long s=0;
		
		for(int i=n-1;i>=0;i--){
			s+=(long)arr[i].len;
			sum[i]=s;
		}
		
		
		for(int i=0;i<n;i++){
			
			int curr_beauty=arr[i].beauty;
			if(n-i<=k)
				max=Math.max(sum[i]*curr_beauty,max);
				
			else{
				
				  PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
				  pq.add(arr[i].len);
				  int j=i+1;
				  
				  for(j=i+1;j<n && pq.size()<=k ;j++)
			      {
			        pq.add(arr[j].len);
			      }
			      
			      for(int p=j;p<n;p++){
			      	if(arr[p].len>pq.peek()){
			      		int dummy=pq.remove();
			      		pq.add(arr[p].len);
			      	}
			      }	
			      long temp=0;
		      	  for(int p=0;p<k;p++){
		      	  	temp+=(long)pq.remove();
		      	  	
		      	  }
		      	  
		      	  max=Math.max(curr_beauty*temp,max);
		      	
		      }
		}
		
		return max;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		Pair arr[]=new Pair[n];
		for(int i=0;i<n;i++){
			int len=sc.nextInt();
			int beauty=sc.nextInt();
			arr[i]=new Pair(len,beauty);
		}
		
		System.out.println(func(arr,n,k));
	}
}
