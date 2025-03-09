import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int[][][][] map = new int[19][19][19][19];
        int[][][][] set = new int[19][19][19][19];
        int id =0;
        while(sc.hasNext()){
            int s = sc.nextInt();
            id++;
            int[] v = new int[2001];
            v[0] = s%10;
            for(int i=1; i<=2000; i++){
                s = next(s);
                v[i] = s%10;
                if(i>=4){
                    int d[] = new int[4];
                    for(int j=0; j<4; j++){
                        d[j] = v[i-3+j]-v[i-4+j]+9;
                        if(d[j]==-1)System.out.println(v[i-3+j]+" "+v[i-4+j]);
                    }
                    if(set[d[0]][d[1]][d[2]][d[3]]!=id){
                        set[d[0]][d[1]][d[2]][d[3]] = id;
                        map[d[0]][d[1]][d[2]][d[3]] += v[i];
                    }
                }
            }
        }
        for(int a=0; a<19; a++){
        for(int b=0; b<19; b++){
        for(int c=0; c<19; c++){
        for(int d=0; d<19; d++){
            ans =  Math.max(map[a][b][c][d], ans);
        }}}
        }
        System.out.println(ans);
    }
    static int rem = 1<<24;
    static int next(int s){
        s ^= s<<6;
        // s%=rem;
        s&=rem-1;
        s ^= s>>5;
        s&=rem-1;
        // s%=rem;
        s ^= s<<11;
        s&=rem-1;
        // s%=rem;
        return s;
    }
}