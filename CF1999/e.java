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
        int l = scanner.nextInt(), r = scanner.nextInt();
        int s = 1, e = 12;
        while(s<e){
            int m = (s+e)/2;
            int x = pow(m);
            if(x > l){
                e = m;
            }else{
                s = m+1;
            }
        }
        int first = s;
        int d = pow(first);

        // int ans = (Math.min(r+1,d)-l+1)*first;
        
        // int l = Math.max(l,d+1);
        // while(l<r){

        // }
        int ans = first;
        for(; l<=r; ){
           ans+= (Math.min(r, d-1) -l +1)*first;
             l= d;
            d*=3;
            first++;
        }
        System.out.println(ans);
    }

    static int pow(int p){
        if(p==1) return 3;
        return pow(p/2) * pow((p+1)/2);
    }
}