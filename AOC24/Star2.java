import java.lang.*;
import java.util.*;

 class Solution{
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            a.add(sc.nextInt());
            int b = sc.nextInt();
            hm.put(b, hm.getOrDefault(b, 0)+1);
        }

        long ans = 0;
        for(int i=0; i<a.size(); i++){
            ans+= (long)a.get(i)* hm.getOrDefault(a.get(i), 0);
        }
        System.out.println(ans);
    }
    
}