import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
      
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      
      for(int i=1;i<=n;i++){
        map.put(i,0);
      }
      
      int flag=0;
      int swaps=0;
      
      int arr[]=new int[n];
      
      for(int i=0;i<n;i++){
        
        arr[i]=sc.nextInt();
        
      }
      
      
      
      for(int i=0;i<n;i++){
        
      	if(arr[i]==i+1){
          
        }
        
        else if(i<n-2){
          if(arr[i+1]==i+1){
            
            if(map.get(arr[i])==2){
              flag=1;
              break;
            }
            
            if(map.get(arr[i])==2 || map.get(arr[i+1])==2){
              flag=1;
              break;
            }

            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
            swaps++;
            int c1=map.get(arr[i]);
            int c2=map.get(arr[i+1]);
            c1++;
            c2++;
            
            map.put(arr[i],c1);
            map.put(arr[i+1],c2);
            
          }
          
          else if(arr[i+2]==i+1){
            
            if(map.get(arr[i])==2 || map.get(arr[i+1])==2 || map.get(arr[i+2])>0){
              flag=1;
              break;
            }
            
            int temp=arr[i];
            arr[i+2]=arr[i+1];
            arr[i+1]=arr[i];
            arr[i]=i+1;
            swaps+=2;
            
            int c1=map.get(i+1);
            map.put(c1,2);
            int c2=map.get(arr[i+2]);
            c2++;
            map.put(arr[i+2],c2);
            int c3=map.get(arr[i+1]);
            c3++;
            map.put(arr[i+1],c3);
            
            
          }
          
          else{
            flag=1;
            break;
          }
          
          
        }
        
        else if(i<n-1){
          if(arr[i+1]==i+1 && arr[i]==i+2 && map.get(arr[i])<=1 && map.get(arr[i+1])<=1){
            swaps++;
          }
          else{
            flag=1;
            break;
          }
        }
        
      }
      
      
      if(flag==1){
        
        System.out.println("NO");
      }
      
      else{
        System.out.println("YES");
        System.out.println(swaps);
      }

	}

}
