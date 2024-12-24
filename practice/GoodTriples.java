import java.util.*;

class Solution{

    private int findGoodTriples(List<Integer> a, List<Integer> b, List<Integer> c, int d, int t1, int t2){
        assert !a.isEmpty() && !b.isEmpty() && !c.isEmpty();
        int leftb = 0, rightb = 0;
        int leftc = 0, rightc = 0;
        int ans = 0;
        for(int i=0; i<a.size(); i++){
            while(leftb < b.size() && b.get(leftb) < a.get(i)-d) leftb++;
            while(rightb < b.size() && b.get(rightb)+t1 <= a.get(i)) rightb++;


            while(leftc < c.size() && c.get(leftc) < a.get(i)-d) leftc++;
            while(rightc < c.size() && c.get(rightc)+t2 <= a.get(i)) rightc++;
            
            ans += (rightc-leftc) * (rightb - leftb);
        }
        return ans;
    }

    public static void main(String args[]){
        List<Integer> a = Arrays.asList(1,2,3,3);
        List<Integer> b = Arrays.asList(1,2,3,3);
        List<Integer> c = Arrays.asList(1,2,3,3);
        int ans = 0;
        int d = 0;
        Solution ob = new Solution();
        // a >=b , a >= c
        ans += ob.findGoodTriples(a, b, c, d, 0, 0);
        // c >= b, c > a
        ans += ob.findGoodTriples(c, b, a, d, 0, 1);
        // b > a, b > c
        ans += ob.findGoodTriples(b, a, c, d, 1, 1);
        System.out.println(ans);
    }
}