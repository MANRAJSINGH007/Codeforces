import java.util.*;

public class mashmokh_and_acm{
    
    static int mod=(int)Math.pow(10,9)+7;
    
    public static int numberOfSequences(int k, int prev, int[][] dp, boolean[] prime){
        
        if(k==0){
            return 1;
        }

        if(prev==1){
            return dp[prev][k]=1;
        }

        if(prime[prev]){

            if(k==1){
                return dp[prev][k]=2;
            }

            return dp[prev][k]=2+k-1;
        }

        if(dp[prev][k]!=-1){
            return dp[prev][k];
        }

        long smallOutput=0;
        
        for(int j=(int)Math.sqrt(prev);j>0;j--){
            
            if(prev%j==0){
                
                int temp1=numberOfSequences(k-1,j,dp,prime);
                smallOutput=smallOutput+temp1;
                smallOutput%=mod;

                if(j!=prev/j){

                    temp1=numberOfSequences(k-1,prev/j,dp,prime);
                    smallOutput=smallOutput+temp1;
                    smallOutput%=mod;
                }
                
            }
            
        }
        
        return dp[prev][k]=(int)smallOutput%mod;
        
    }
    
    
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int dp[][]=new int[n+1][k+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=-1;
            }
        }

        boolean prime[]=new boolean[2001];
        prime[2]=true;
        prime[3]=true;

        for(int i=4;i<=2000;i++){

            int flag=0;
            for(int j=2;j<=(int)Math.sqrt(i);j++){

                if(i%j==0){
                    flag=1;
                    break;
                }

            }

            if(flag==0){
                prime[i]=true;
            }
        }

        long ans=0;

        for(int i=1;i<=n;i++){

            int temp=numberOfSequences(k-1,i,dp,prime);
            ans=ans+temp;
            ans%=mod;
        }

        System.out.println((int)ans%mod);

        
    }
    
    
    
}
