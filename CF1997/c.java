import java.util.*;

public final class c{
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
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for(int i=0; i<n; i++){
            char c = a.charAt(i);
            if(c == '_'){
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans += i -stack.pop();
                }
            }else{
                if(c == '('){
                    stack.push(i);
                }else{
                    ans+= i - stack.pop();
                }
            }
        }
        System.out.println(ans);
    }
}