import java.util.*;

public final class d1{
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
        int q = scanner.nextInt();
        H = (int)Math.log(n+1);
        assert n !=3 || H == 2;
        assert n != 7 || H == 3;
            System.out.println(H);
        int tree[] = new int[n+1];
        tree[1] =  1;

        int perm[] = new int[n+1];
        for(int i=2; i<=n; i++){
            int p = scanner.nextInt();
            if(tree[p*2]==0) tree[p*2] = i;
            else tree[p*2+1] = i;
        }

        for(int i=0; i<n; i++){
            perm[i+1] = scanner.nextInt();
        }

            // System.out.println(Arrays.toString(tree));
        for(int i=0; i<q; i++){
            int x = scanner.nextInt(), y = scanner.nextInt();
            int t = perm[x];
            perm[x] = perm[y];
            perm[y] = t;
            // System.out.println(Arrays.toString(perm));
            if(isValid(tree, perm, 1, 1, 0)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static int H = 0;
    static boolean isValid(int tree[], int perm[], int r1, int r2, int h){
        if(r1>=tree.length) return true;
        if(tree[r1]!=perm[r2]) return false;
        int depth = H-h-1;
        int size = (1 << depth )- 1;
        return (isValid(tree, perm, r1*2, r2+1, h+1) && isValid(tree, perm, r1*2+1, r2+size, h+1))
                || (isValid(tree, perm, r1*2+1, r2+1, h+1) && isValid(tree, perm, r1*2, r2+size, h+1));
    }
}