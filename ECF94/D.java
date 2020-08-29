import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
  
public class D 
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
    long tc(){
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = in.nextInt();
        ArrayList<ArrayList<Integer>> map= new ArrayList<>(n+1);
        for(int i=0; i<=n; i++)
        map.add(new ArrayList<>());
        for(int i=0; i<n; i++)
        map.get(arr[i]).add(i);
        long ans = 0;
        for(int i=1; i<=n; i++){
            if(map.get(i).size()<2) continue;
            for(int j=1; j<=n; j++){
                if(map.get(j).size()<2) continue;
                if(i==j){
                    if(map.get(i).size()>=4)
                    ans += fact(map.get(i).size());
                }else{
                    List<Integer> ft = map.get(i);
                    List<Integer> st = map.get(j);
                    int t1=0, rt1 = 0,  t2=0, rt2 = 0;
                    for(t1 = 0; t1<ft.size()-1; t1++){
                        for(t2 = rt2; t2<st.size(); t2++){
                            if(st.get(t2)>ft.get(t1))
                            break;
                        }
                        rt1 = t1;
                        while(rt1<ft.size() && ft.get(rt1)<st.get(t2)) rt1++;
                        if(rt1==ft.size()) break;
                        rt2 = t2;
                        while(rt2<st.size() && st.get(rt2)<ft.get(rt1)) rt2++;
                        if(rt2==st.size()) break;
                        ans += (rt1-t1)*(rt2-t2)*(rt2-st.size()+1);
                        System.out.println(t1+" "+rt1+" "+t2+" "+rt2);
                        t1 = rt1;

                    }
                }
            }
        }
        System.out.println(map);
        return ans;
    }
    long fact(int n){
        if(n==4) return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args) 
    { 
        StringBuilder out = new StringBuilder();
        D ob = new D();
        int t = in.nextInt();
        while(t-->0){
           out.append(ob.tc()+"\n");
        }
        System.out.print(out);
    } 
} 