import java.lang.*;
import java.util.*;

 class Solution{
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        int safe  = 0;
        while(sc.hasNext()){
            String report = sc.nextLine();
            String[] vals = report.split(" ");
            List<Integer> list = new ArrayList<>(vals.length);
            for(String i: vals) list.add(Integer.parseInt(i));
            boolean isAnyOk = false;
            int i=0;
            isAnyOk = isSafe(list, 0);
            for( i=1; i<vals.length; i++){
                int prev = list.get(i-1);
                int cur = list.get(i);
                int dif = Math.abs(prev-cur);
                if(!(dif==1||dif==2||dif==3)){
                    isAnyOk = isAnyOk|| isSafe(list, i) || isSafe(list, i-1);
                    break;
                };
                if(i>1){
                    if((list.get(i-2) > list.get(i-1) && list.get(i) > list.get(i-1))
                    || (list.get(i-2) < list.get(i-1) && list.get(i) < list.get(i-1))
                    ){
                        isAnyOk = isAnyOk || isSafe(list, i-1) || isSafe(list, i-2) || isSafe(list, i);
                        break;
                    }
                }
            }
            if(isAnyOk)
            safe++;
        }

        System.out.println(safe);
    }

    static boolean isSafe(List<Integer> arr, int flag){
        boolean inc = true, dec = true;
        int i=0;
        for( i=(flag==0?2:1); i<arr.size(); i++){
            if(i==flag) continue;
            int prev = (i-1 == flag)? arr.get(i-2): arr.get(i-1);
            int cur = arr.get(i);
            int dif = Math.abs(prev-cur);
            if(prev < cur){
                dec = false;
            }else{
                inc = false;
            }
            if(!(dif==1||dif==2||dif==3)) break;
        }
        return i==arr.size() && (inc || dec);
    }
    
}