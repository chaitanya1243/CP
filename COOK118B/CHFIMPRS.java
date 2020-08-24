import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*; 
  
class  CHFIMPRS
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

    void tc(StringBuilder out){
        int n = in.nextInt(), m = in.nextInt();
        int arr[][] = new int[n][m];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++)
        for(int j=0; j<m; j++){
            arr[0][0] = in.nextInt();
            hm.put(arr[0][0], hm.getOrDefault(arr[0][0],0)+1);
        }
        if(hm.size()>n*m-m/2*n){
            out.append(-1+"\n");
            return;
        }
        List<Integer> odds = new ArrayList<>();
        for(Map.Entry<Integer, Integer> i: hm.entrySet())
        if((i.getValue()&1)==1) odds.add(i.getKey());
        if(odds.size() != (m&1)*n){
            out.append(-1+"\n");
            return;
        }
        //fill odds
        if(odds.size()>0)
        for(int i=0; i<n; i++){
            arr[i][m/2]=odds.get(i);
            int temp = hm.get(odds.get(i));
            if(temp==1) 
                hm.remove(odds.get(i));
            else
                hm.put(odds.get(i), temp-1);
        }
        Iterator<Map.Entry<Integer, Integer>> itr = hm.entrySet().iterator();
        int k=0,v=0;
        for(int i=0; i<n; i++){
            for(int j=0; m-1-j>j; j++){
                if(v==0){
                    Map.Entry<Integer, Integer> e = itr.next();
                    // System.out.println(e);
                    k = e.getKey();
                    v = e.getValue();
                }
                arr[i][j] = k;
                arr[i][m-1-j] = k;
                v-=2;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                out.append(arr[i][j]+" ");
            }
            out.append("\n");
        }
    }

    static final FastReader in = new FastReader();

    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        CHFIMPRS ob = new CHFIMPRS();
        int t = in.nextInt();
        while(t-->0){
            ob.tc(out);
        }
        System.out.println(out);
    }
} 