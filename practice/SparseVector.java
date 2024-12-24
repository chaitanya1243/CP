
import java.util.*;

class SparseVector{

    private HashMap<Integer, Integer> map = new HashMap<>();
    public SparseVector(List<Integer> nums) {
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i)!=0){
                map.put(i, nums.get(i));
            }
        }
    }

    public int dotProduct(SparseVector other){
        int ans = 0;
        for( var i : map.entrySet()){
            ans += i.getValue() * other.map.getOrDefault(i.getKey(), 0);
        }
        return ans;
    }

}


class Main{
    public static void main(String args[]){
        List<Integer> x = Arrays.asList(1,0,0,2,3);
        List<Integer> y = Arrays.asList(0,3,0,4,0);
        var v = new SparseVector(x);
        var d =v.map;

        System.out.println(new SparseVector(x).dotProduct(new SparseVector(x)));
    }
}