import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<String> map = new ArrayList<>();

        while(sc.hasNext()){
            map.add(sc.nextLine());
        }

        int n = map.size(), m = map.get(0).length();
        HashMap<Character, List<List<Integer>>> hm = new HashMap<>();
        Set<List<Integer>> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char c = map.get(i).charAt(j);
                if(c!='.'){
                    if(!hm.containsKey(c)){
                        hm.put(c, new ArrayList<>());
                    }
                        hm.get(c).add(List.of(i, j));
                }
            }
        }
        // System.out.println(hm);
        // System.out.println(n+" "+m);
        for(var freq: hm.entrySet()){
            var locs = freq.getValue();
            for(int i=0; i<locs.size()-1; i++){
                for(int j= i+1; j<locs.size(); j++){
                    var p1 = locs.get(i); 
                    var p2 = locs.get(j);
                    int dist = 0;
                    // b:for(int x = p1.get(0)-1; x >=0; x--){
                    //     for(int y=0; y<m; y++){
                    //         if(x!=p1.get(0)&&x!=p2.get(0)){
                    //             if(lhs(y, p1, p2) == rhs(x, p1, p2)){
                    //                 hs.add(List.of(x,y));
                    //                 // System.out.println(lhs(y, p1, p2)+"="+rhs(x, p1, p2));
                    //                 // System.out.println(lhs(y, p1, p2)+"="+rhs(x, p1, p2));
                    //                 System.out.println(x+" "+y);
                    //                 dist = p1.get(0)-x;
                    //                  break b;
                    //             }
                    //         }
                    //     }
                    // }

                    b:for(int x = 0; x<n; x++){
                        for(int y=0; y<m; y++){
                            // if(x!=p1.get(0)&&x!=p2.get(0)){
                                if(lhs(y, p1, p2) == rhs(x, p1, p2)){
                                    hs.add(List.of(x,y));
                                    // System.out.println(lhs(y, p1, p2)+"="+rhs(x, p1, p2));
                                    // System.out.println(lhs(y, p1, p2)+"="+rhs(x, p1, p2));
                                    // System.out.println(x+" "+y);
                                    // if(--need==0) break b;
                                    // break b;
                                }
                            // }
                        }
                    }
                }
            }
        }
        System.out.println(hs.size());
        
    }
    static int lhs(int y, List<Integer> p1, List<Integer> p2){
        return (y-p1.get(1))*(p2.get(0)-p1.get(0));
    }
    static int rhs(int x, List<Integer> p1, List<Integer> p2){
        return (x-p1.get(0))*(p2.get(1)-p1.get(1));
    }
}