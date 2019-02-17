import java.util.*;

class equalise{
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        String a=sc.next();
        String b=sc.next();
        int cost=0;
        
        for(int i=0;i<n;i++){
            
            if(a.charAt(i)==b.charAt(i)){
                
            }
            
            else{
                
                if(i!=n-1 && a.charAt(i)!=a.charAt(i+1) && a.charAt(i)==b.charAt(i+1)){
                    
                    cost++;
                    i++;
                }
                
                else{
                    
                    cost++;
                }
                
            }
            
            
        }
        
        System.out.println(cost);
        
    }
    
}
