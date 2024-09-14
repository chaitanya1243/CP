import java.util.*;

public final class g{
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
        int l = 2, r = 999;
        while(r-l > 1){
            int m1 = Math.max(l+ ((r-l)/4), l), m2 = l+ ((3*(r-l))/4);
            System.out.println("? "+m1+ " "+m2);
            System.out.flush();
            int x = scanner.nextInt();
            if((m1+1)*(m2+1)==x){
                r = m1;
            }else if(m1*(m2+1)==x){
                l =m1+1;
                r =m2;
            }else {
                l = m2+1;
            }
        }
        if(r-l == 1){
            System.out.println("? "+1+ " "+l);
            System.out.flush();
            int x = scanner.nextInt();
            if(l==x) l=r;
        }
        System.out.println("! "+l);
    }


}