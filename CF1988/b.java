import java.util.*;

public final class b{
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
        scanner.nextLine();
        String s = scanner.nextLine().trim();
        int ones = 0;
        int zeros = 0;
        boolean zero = false;
        for(char c: s.toCharArray()){
            if(c == '0'){
                if(!zero) zeros++;
                zero = true;
            }else{
                zero = false;
                ones++;
            }
        }
        if(ones > zeros){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}