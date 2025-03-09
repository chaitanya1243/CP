import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<Long> li = new ArrayList<>();
        long ans = 0;
        HashMap<Long, Long> hm = new HashMap<>();
        while(sc.hasNext()){
            // li.add(sc.nextLong());
            hm.put(sc.nextLong(), 1l);
        }
        for(int i=0; i<75; i++){
            HashMap<Long, Long> newHm = new HashMap<>();
            for(Map.Entry<Long, Long> s: hm.entrySet()){
                long k = s.getKey();
                long v = s.getValue();
                if(k==0){
                    newHm.put(1l, newHm.getOrDefault(1l, 0l)+v);
                }else if((k+"").length()%2==0){
                    String ss = k+"";
                    int mid = ss.length()/2;
                    long f = Long.parseLong(ss.substring(0, mid)), l =Long.parseLong( ss.substring(mid));
                    newHm.put(f, newHm.getOrDefault(f, 0l)+v);
                    newHm.put(l, newHm.getOrDefault(l, 0l)+v);
                }else{
                    newHm.put(k*2024, newHm.getOrDefault(k*2024, 0l)+v);
                }
            }
            hm = newHm;
        }
        for(var i: hm.entrySet()){
            ans+= i.getValue();
        }
        System.out.println(ans);
    }
    // static int max = 500000005;
    // static int dp[][] = new int[max][76];
    // static int f(long num, int i){
    //     if(i==0) return 1;
    //     if(dp[(int)num][i]!=0) return dp[(int)num][i];
    //     if(num==0){
            
    //         return dp[(int)num][i]=f(1, i-1);
    //     } 
    //     String s = num+"";
    //     if(s.length()%2==0){
    //         int mid = s.length()/2;
    //         return dp[(int)num][i]=f(Integer.parseInt(s.substring(0,mid)),i-1)+ f(Integer.parseInt(s.substring(mid, s.length())), i-1);
    //     }
    //     return dp[(int)num][i]=f(num*2024, i-1);
    // }
}