import java.util.*;

public final class e{
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
        int n = scanner.nextInt();
        long pairs[][] = new long[n][2];
        for(int i=0; i<n; i++){
            pairs[i][0] = scanner.nextLong();
            pairs[i][1] = scanner.nextLong();
        }
        long s = pairs[0][0];
        Stack<long[]> stack = new Stack<>();
        for(long[] p: pairs){
            long last = 0;
            while(stack.isEmpty()==false && stack.peek()[0]<=p[0]){
                last = stack.pop()[0];
                if(stack.isEmpty()==false && stack.peek()[1]==p[1]){
                    p[0]=stack.peek()[0]+p[0]-last;
                }
            }
            stack.push(p);
            s = Math.max(s, stack.peek()[0]);
            System.out.print(s+" ");
            // System.out.print(s+" "+stack.peek()[0]+"/"+stack.size()+" ");
        }
        System.out.println();
    }
}