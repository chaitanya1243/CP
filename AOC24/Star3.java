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
            String[] valStrings = report.split(" ");
            if(valStrings.length==1){
                // safe++;
                continue;
            }
            boolean increasing = Integer.parseInt(valStrings[1]) > Integer.parseInt(valStrings[0]);
            int i =0;
            for( i=1; i<valStrings.length; i++){
                int prev = Integer.parseInt(valStrings[i-1]);
                int cur = Integer.parseInt(valStrings[i]);
                int dif = Math.abs(prev-cur);
                if(!((dif==1||dif==2||dif==3)&& ((prev < cur) == increasing))) break;
            }
            if(i== valStrings.length) safe++;
        }

        System.out.println(safe);
    }
    
}