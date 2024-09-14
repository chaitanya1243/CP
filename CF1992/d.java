import java.util.*;

public final class d{
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
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        String r = scanner.nextLine().trim();
        int lastLog = -1;
        for(int i=0; i<n; i++){
            char c = r.charAt(i);
            if(c == 'W'){
                if(i >= lastLog+m && k > 0) k--;
                else if(i >= lastLog+m && k == 0){
                    System.out.println("NO");
                    return;
                }
            }else if(c=='C'){
                if(i >= lastLog+m){
                    System.out.println("NO");
                    return;
                }
            }else{
                lastLog = i;
            }
        }
        System.out.println("YES");
    }
}