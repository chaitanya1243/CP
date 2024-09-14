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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();

        int a = (x+k-1)/k, b = (y+k-1)/k;

        if(a>b){
            System.out.println(2*a-1);
        }else{
            System.out.println(2*b);
        }
    }

}