import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line = "";
        List<int[]> locks = new ArrayList<>();
        List<int[]> keys = new ArrayList<>();
        while(sc.hasNext()){
            char [][] arr = new char[7][5];
            int r=0;
            while(r<7){
                line = sc.nextLine();
                arr[r++] = line.toCharArray();
            }
            if(sc.hasNext())
            sc.nextLine();
            int d = (arr[0][0]=='#')?1:-1;
            int[] f = new int[5];
            for(int i=0; i<5; i++){
                for(int j=d==1?0:6; true; j+=d){
                    if(arr[j][i]!=arr[j+d][i]){
                        f[i] = d==1?j:6-j;
                        break;
                    }
                }
            }
            // System.out.println(Arrays.toString(f));
            if(d==1){
                locks.add(f);
            }else{
                keys.add(f);
            }
        }
        int c =0;
        for(var l:locks){
            for(var k: keys){
                int i=0; 
                for(; i<5; i++){
                    if(l[i]+k[i]>=6) break;
                }
                if(i==5) c++;
            }
        }
        System.out.println(c);
    }
}