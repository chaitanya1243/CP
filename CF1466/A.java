import java.util.*;

public class A
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-->0){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++) arr[i] = in.nextInt();

            Set<Integer> s = new HashSet<>();

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    s.add(arr[j]-arr[i]);
                }
            }
            System.out.println(s.size());
        }
    
    }
}