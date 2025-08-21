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

    static void solve(Scanner sc){
        String s = sc.nextLine();
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int t = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(arr[i]=='T'){
                t++;
            }else{
                sb.append(arr[i]);
            }
        }
        StringBuilder ns = new StringBuilder();
        for(int i=0; i<t; i++) ns.append('T');

        System.out.println(ns.toString()+sb.toString());
    }
}