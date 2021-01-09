import java.util.*;

public class E
{
    public static int findBest(Integer[][] arr, int v) {
        int lo = 0, hi = arr.length-1;
        while(lo<hi){
            int mid = lo+(hi-lo+1)/2;
            if(arr[mid][1]<v) lo = mid;
            else hi = mid-1;
        }
        if(arr[lo][1]>=v) return -1;
        return lo;
    }

    public static void solve(Scanner in) {
        int n = in.nextInt();
        Integer[][] mat = new Integer[n][3];
    
        for(int i=0; i<n; i++){
            mat[i] = new Integer[]{i+1, in.nextInt(), in.nextInt()};
        }

        Integer[][] arr = mat.clone();

        Arrays.sort(mat, (a,b) -> a[1]-b[1]);
        
        for(int i=1; i<n; i++){
            if(mat[i-1][2] < mat[i][2])
            mat[i] = mat[i-1];
        }

        for(int i=0; i<n; i++){
            int h = arr[i][1], w = arr[i][2];

            int idx1 = findBest(mat, h), idx2 = findBest(mat, w);
            if(idx1 != -1 && mat[idx1][2] < w)
                System.out.print(mat[idx1][0]+" ");
            else if(idx2 != -1 && mat[idx2][2] < h)
                System.out.print(mat[idx2][0]+" "); 
            else
                System.out.print("-1 ");

        }

        // int harr[] = new int[hmax+1];

        // Arrays.fill(harr, -1);

        // for(int i=0; i<n; i++){
        //     if(harr[hs[i]]==-1 || ws[harr[hs[i]]] > ws[i])
        //     harr[hs[i]] = i;
        // }

        // for(int i=2; i<=hmax; i++){
        //     if(harr[i-1]==-1) continue;
        //     if(harr[i]==-1 || ws[harr[i-1]] < ws[harr[i]])
        //     harr[i] = harr[i-1];
        // }

        // for(int i=0; i<n; i++){
        //     // int idx = harr[hs[i]-1];
        //     // if(idx!=-1 && hs[idx]<hs[i] && ws[idx]<ws[i]){
        //     //     System.out.print(idx+1+" ");
        //     //     continue;
        //     // }
        //     // idx = warr[ws[i]-1];
        //     // if(idx!=-1 && ws[idx]<hs[i] && hs[idx]<ws[i]){
        //         //     System.out.print(idx+1+" ");
        //         //     continue;
        //         // }
        //         // System.out.print("-1 ");
                
        //         int idx1 = harr[hs[i]-1], idx2 = harr[(ws[i]>hmax?hmax:ws[i]-1)];
        //         if(idx1 != -1 && ws[idx1] < ws[i])
        //             System.out.print(idx1+1+" ");
        //         else if(idx2 != -1 && ws[idx2] < hs[i])
        //             System.out.print(idx2+1+" "); 
        //         else
        //             System.out.print("-1 "); 
        //     }

        // System.out.println(Arrays.deepToString(mat));
        // System.out.println(Arrays.toString(warr));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}
