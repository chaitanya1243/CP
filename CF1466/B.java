import java.util.*;

public class B
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-->0){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++) arr[i] = in.nextInt();

            int ans = 1;

            

            for(int i=1; i<n; i++){
                if(arr[i-1]>=arr[i]){
                    arr[i]++;
                }
            }

            for(int i=1; i<n; i++)
            if(arr[i]!=arr[i-1])
            ans++;

            System.out.println(ans);
            // System.out.println(Arrays.toString(arr));s
        }
    
    }
}