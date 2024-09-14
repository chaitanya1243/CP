import java.util.*;

public final class d{
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
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        char[] sArr = s.toCharArray();

        int i = 0, j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j) || s.charAt(i)=='?'){
                j++;
                if(s.charAt(i)=='?'){
                    sArr[i] = t.charAt(j-1);
                }
            }
            i++;
        }
        while(i<s.length()){
            if(s.charAt(i)=='?'){
                sArr[i] = 'a';
            }
            i++;
        }
        if(j<t.length()){
            System.out.println("NO");}
        else{
            System.out.println("YES");
            System.out.println(new String(sArr));
        }
    }
}