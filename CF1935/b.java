import java.util.*;

//codeforces question basic template
 public final class b{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int n = scanner.nextInt();
            int[] arr =  new int[n];
            for(int j=0; j<n; j++){
                arr[j] = scanner.nextInt();
            }
            solve(arr);
        }

        
        scanner.close();
    }

    static void solve(int[] arr){
        int n = arr.length;
        ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) count.add(new ArrayList<Integer>());
        for(int i=0; i<n; i++){
            count.get(arr[i]).add(i);
        }
        if(count.get(0).size() == 0){
            System.out.println(2);
            System.out.println("1 1");
            System.out.println("2 "+ n);
            return;
        }
        for(int i=1;i<=n/2; i++){
           if(count.get(i).size() >0) continue;
           int firstMax = -1;
           int j = 0;
           for( j=0; j<i; j++){
            if(count.get(j).size() < 2) break;
            firstMax = Math.max(firstMax, count.get(j).get(0));
           }
            if(firstMax != -1 && j == i){
            boolean possible = true;
            for( j=0; j<i; j++){
                int sz = count.get(j).size();
                if(count.get(j).get(sz-1) < firstMax){
                    possible = false;
                    break;
                }
            }
            if(possible){
                System.out.println(2);
                System.out.println("1 "+(firstMax+1));
                System.out.println((firstMax+2)+" "+n);
                return;
            }
            }
           break;
        }
        System.out.println(-1);
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