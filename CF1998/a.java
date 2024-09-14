import java.util.*;

public final class a{
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();

        x *= k;
        y *= k;

        for(int i=1; i<k; i++){
            System.out.println(i + " " + i);
        }
        int a = (k*(k-1))/2;
        System.out.println(x-a + " " + (y-a));
    }
}