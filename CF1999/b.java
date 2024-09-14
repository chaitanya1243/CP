import java.util.*;

public final class b{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int a[] = new int[]{0, scanner.nextInt(), scanner.nextInt()};
        int b[] = new int[]{0, scanner.nextInt(), scanner.nextInt()};

        int ans = 0;

        if(a[1] >= b[1] && a[2] >= b[2] && (a[1] > b[1] || a[2] > b[2]))
            ans++;
        if(a[1] >= b[2] && a[2] >= b[1] && (a[1] > b[2] || a[2] > b[1]))
            ans++;

        System.out.println(ans*2);
    }
}