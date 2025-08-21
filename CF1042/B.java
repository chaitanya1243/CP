import java.util.*;

public final class B{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
            // solve2(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner in){
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            if(i==n-1 && n%2 == 0){
                System.out.print(2+" ");
                break;
            }
            if(i%2 == 0){
                System.out.print(-1+" ");
            }else{
                System.out.print(3+" ");
            }
        }
        System.out.println();
    }

}