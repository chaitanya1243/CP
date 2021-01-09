import java.util.*;

public class C
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-->0){
            String s = in.next();
            int n = s.length();

            char arr[] = s.toCharArray();
            int ans = 0;
            for(int i=1; i<n; i++){
                if(arr[i]==arr[i-1]){
                    ans++;
                    arr[i] = '.';
                }else if(i>1 && arr[i-2]==arr[i]){
                    ans++;
                    arr[i] = '.';
                }
            }
        
            System.out.println(ans);
            // System.out.println(Arrays.toString(arr));s
        }
    
    }
}