import java.util.*;

public class kefa_and_first_steps{
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int maxSoFar=1;
        int curr=1;
        
        for(int i=1;i<n;i++){
            
            if(arr[i]>=arr[i-1]){
               
               curr++;
               if(curr>maxSoFar){
                   maxSoFar=curr;
                   
               }
            }
               else{
                   curr=1;
               }
            
        }
        
        if(curr>maxSoFar){
           maxSoFar=curr;
           
       }
        
       System.out.println(maxSoFar);
    }
    
}
