import java.util.*;

public class D
{

    public static void solve(Scanner in) {
        int n = in.nextInt();

        Integer arr[] = new Integer[n];

        for(int i=0; i<n; i++) arr[i] = in.nextInt();

        Arrays.sort(arr, (a,b) -> b-a);

        // System.out.println(Arrays.toString(arr));

        long a = 0, b = 0;
        boolean even = true;
        for(int i=0; i<n; i++){
            even = ((arr[i]&1) == 0);
            if((i&1) == 0) a += (even?arr[i]:0);
            else b += (even?0:arr[i]);
            // System.out.printf("a: %d, b: %d%n",a, b);
        }

        if(a>b)
        System.out.println("Alice");
        else if(a<b)
        System.out.println("Bob");
        else
        System.out.println("Tie");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}
