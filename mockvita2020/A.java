import java.util.*;

class A
{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int lo = 1, hi = 30;
      while(lo<hi){
        int mid = lo+(hi-lo)/2;
        if(f(mid)>=n) hi=mid;
        else lo=mid+1;
      }
      System.out.println(lo);
    }
  }
  static int f(int n){
      int ans=1;
      for(int i=1; i<n; i++){
          ans+=1<<i;
      }
      return ans;
  }
}