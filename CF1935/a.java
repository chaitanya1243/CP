import java.util.*;

//codeforces question basic template
 public final class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int n = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(solve(n,s));
        }

        
        scanner.close();
    }

    static String solve(int n, String s){
        Boolean shouldReverse = null;
        for(int i=0; i<s.length(); i++){
            int j = s.length()-1-i;
            if(s.charAt(i)==s.charAt(j)) continue;

            if(s.charAt(i) < s.charAt(j))
            shouldReverse = false;
            else
            shouldReverse = true;
            break;
        }

        if(shouldReverse == null) return s;

        if(n%2 == 0){
            if(!shouldReverse) return s;
            else return reverse(s) + s;
        }else{
            if(shouldReverse) return reverse(s);
            else return s + reverse(s);
        }
    }

static String reverse(String s){
    StringBuilder sb = new StringBuilder();
    for(int i=s.length()-1; i>=0; i--){
        sb.append(s.charAt(i));
    }
    return sb.toString();
}
}
// n = 5
// 0 0 1 1 3