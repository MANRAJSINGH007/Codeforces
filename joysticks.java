import java.util.*;

class joystick{
    
    public static int maxTime(int a, int b, int[][] dp){
        

        if(dp[a][b]!=-1){

            return dp[a][b];
        }

        if(a==0 || b==0){
            return 0;
        }
        
        if(a==1 && b==1){
            return 0;
        }

        if(a==1){
            return dp[a][b]=1+maxTime(a+1,b-2,dp);
            
        }
        
        if(b==1){
            return dp[a][b]=1+maxTime(a-2,b+1,dp);
        }

        int m1=1+maxTime(a+1,b-2,dp);
        int m2=1+maxTime(a-2,b+1,dp);
        
        return dp[a][b]=Math.max(m1,m2);
        
    }
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        
        int a=sc.nextInt();
        int b=sc.nextInt();
        int dp[][]=new int[200][200];
        for(int i=0;i<200;i++){
            for(int j=0;j<200;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(maxTime(a,b,dp));
        
    }
    
}
