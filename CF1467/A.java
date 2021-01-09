import java.util.*;

public class A
{

    public static void solve(Scanner in) {
        int n = in.nextInt();

        if(n==1)
        System.out.println("9");
        else if(n==2)
        System.out.println("98");
        else{
            StringBuilder s = new StringBuilder();
            s.append("98");
            for(int i=3, x = 9; i<=n; i++, x = (x==9?0:x+1)){
                s.append(x);
            }
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            solve(in);
        }
    }
}