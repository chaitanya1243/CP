import java.util.*;

public final class c{
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
        int n = scanner.nextInt();
        int points[][] = new int[n][2];

        for(int i=0; i<n; i++){
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();

        long d1 = dist(x1, y1, x2, y2);
        for(int[] p: points){
            long d2 = dist(x2, y2, p[0], p[1]);
            if(d2<=d1){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    static long dist(int x1, int y1, int x2, int y2){
        return (long)(x1-x2)*(x1-x2) + (long)(y1-y2)*(y1-y2);
    }
}