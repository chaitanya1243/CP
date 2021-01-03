import java.util.*;

public class A
{
    public static void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            String s = in.next();
            if(s.length()%2 !=0 || s.charAt(0)==')' || s.charAt(s.length()-1)=='(')
            System.out.println("no");
            else
            System.out.println("yes");
        }
    }
    public static void main(String[] args) {    
        solve();
    }
}