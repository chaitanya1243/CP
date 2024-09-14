import java.util.*;

public final class a{
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
        StringBuffer s = new StringBuffer(scanner.nextLine());
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                char c = s.charAt(i);
                if(c=='a'){
                    s.insert(i, 'b');
                }else{  
                    s.insert(i, 'a');
                }
                System.out.println(s.toString());
                return;
            }
        }
        if(s.charAt(s.length()-1)=='a'){
            s.append('b');
        }else{
            s.append('a');
        }
        System.out.println(s.toString());
    }
}