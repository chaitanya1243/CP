
import java.io.*;
import java.util.*; 
  
class ChefandRecipe 
{ 
    class FastReader 
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
    FastReader in = new FastReader();
    String test_case(){
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n; i++)
        arr[i]=in.nextInt();
        Map<Integer, Integer> hm = new HashMap<>();
        Set<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            int get = hm.getOrDefault(arr[i],0);
            if(get!=0 && i>0 && arr[i]!=arr[i-1]) return "NO";
            hm.put(arr[i],get+1);
        }
        for(Map.Entry<Integer, Integer> i: hm.entrySet()){
            if(hs.contains(i.getValue())) return "NO";
            hs.add(i.getValue());
        }
        return "YES";
    }

    public static void main(String[] args) 
    { 
        ChefandRecipe ob = new ChefandRecipe();
        int t = ob.in.nextInt();
        StringBuilder out = new StringBuilder();
        while(t-->0){
            out.append(ob.test_case()+"\n");
        }
        System.out.println(out);
    } 
} 