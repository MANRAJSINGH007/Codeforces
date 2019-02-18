import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      
      int n=sc.nextInt();
      long x=sc.nextInt();
      long y=sc.nextInt();
      String s=sc.next();
      
      int cnt=0;
      int prev=1;
      
      if(s.charAt(0)=='0'){
        cnt++;
        prev=0;
      }
      
      for(int i=1;i<s.length();i++){
        
        if(prev==1 && s.charAt(i)=='0'){
          prev=0;
          cnt++;
        }
        
        else{
          
          if(s.charAt(i)=='1')
          	prev=1;
        }
        
      }
      
      if(cnt==0){
        System.out.println(0);
      }
      
      else{
        System.out.println((cnt-1)*Math.min(x,y)+y);
      }
		
	}
}
