import java.util.*;

public final class a{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if(k==0){
            System.out.println(0);
            return;
        }
        k-=n--;
        int count = 1;
        while(k>0){
            k-=n;
            count++;
            if(count%2==1) n--;
        }
        System.out.println(count);
    }
}