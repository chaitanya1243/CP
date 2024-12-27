import java.lang.*;
import java.util.*;

 class Solution{
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            a.add(sc.nextInt());
            b.add(sc.nextInt());
        }

        Collections.sort(a);
        Collections.sort(b);
        long ans = 0;
        for(int i=0; i<a.size(); i++){
            ans+= Math.abs(a.get(i) - b.get(i));
        }
        System.out.println(ans);
    }
    
}