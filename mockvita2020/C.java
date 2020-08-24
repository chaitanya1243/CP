import java.util.*;

class C
{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    HashMap<Double, Integer> hm = new HashMap<>();
    for(int i=0; i<n; i++){
        double x = Math.sqrt(Math.pow(in.nextLong(),2)+
        Math.pow(in.nextLong(),2))/in.nextInt();
        hm.put(x,hm.getOrDefault(x,0)+1);

    System.out.println(x);
    }
    int ans=0;
    for(Map.Entry<Double, Integer> i:hm.entrySet()){
        int x = i.getValue()-1;
        ans += (x*(x+1))/2;
    }
    System.out.println(ans);
  }
}