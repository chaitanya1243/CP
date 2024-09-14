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

    static char free = '.';

    static void solve(Scanner scanner){
        int n = scanner.nextInt();
        scanner.nextLine();
        StringBuffer a = new StringBuffer(scanner.nextLine());
        StringBuffer b = new StringBuffer(scanner.nextLine());
        int ans = 0;
        for(int i=1; i<n-1; i++){
            int l = i-1, r = i+1;
            if(a.charAt(i)==free && a.charAt(l)==free && a.charAt(r)==free){
                if(b.charAt(l)!=free && b.charAt(r)!=free && b.charAt(i)==free){
                    ans++;
                }
            }
            if(b.charAt(i)==free && b.charAt(l)==free && b.charAt(r)==free){
                if(a.charAt(l)!=free && a.charAt(r)!=free && a.charAt(i)==free){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}