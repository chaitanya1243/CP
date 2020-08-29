import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class C 
{ 
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static final FastReader in = new FastReader();
    int tc(){
        int n = in.nextInt(), m = in.nextInt();
        int arr[][] = new int[n][m+1];

        for(int i=0; i<n; i++)
        arr[i][0] = in.nextInt();

        for(int i=0; i<n; i++)
        for(int j=1; j<=m; j++){
            arr[i][j] = arr[i][j-1]+in.nextInt();
        }

        int ranks[][] = new int[n][m];

        for(int i=1; i<=m; i++){
            TreeMap<Integer, List<Integer>> map = new TreeMap<>((a,b)->b-a);
            for(int j=0; j<n; j++){
                if(!map.containsKey(arr[j][i]))
                map.put(arr[j][i], new ArrayList<>());
                map.get(arr[j][i]).add(j);
            }
            int prev = 0;
            for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
                for(int t: e.getValue())
                ranks[t][i-1] = prev+1;
                prev += e.getValue().size();
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        // System.out.println(Arrays.deepToString(ranks));
        int ans = 0;
        for(int i=0; i<n; i++){
            int bestRank = n+1 , bestRating = Integer.MIN_VALUE;
            int rankMonth = -1, ratingMonth = -1; 
            for(int j=1; j<=m; j++){
                if(arr[i][j]>bestRating){
                    ratingMonth = j;
                    bestRating = arr[i][j];
                }
                if(ranks[i][j-1]<bestRank){
                    bestRank = ranks[i][j-1];
                    rankMonth = j;
                }
            }
            if(rankMonth!=ratingMonth)
            ans++;
        }
        return ans;
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        C ob = new C();
        int t = in.nextInt();
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 