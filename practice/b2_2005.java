import java.util.*;
public final class Solution{

    private Scanner scanner;
    public Solution(Scanner scanner){
        this.scanner = scanner;
    }


    public void solve(){
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        int arr[] = new int[m];

        for(int i=0; i<m; i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<q; i++){
            int pos = scanner.nextInt();

            int l = 0, r = m-1;
            while(l<r){
                int mid = l+(r-l)/2;
                if(arr[mid]>=pos) r = mid;
                else l = mid+1;
            }
            if(arr[l]==pos){
                System.out.println(0);
            }else if(arr[l]<pos){
                System.out.println(n-arr[l]);
            }else if(l==0){
                System.out.println(arr[0]-1);
            }else{
                int mid = (arr[l]+arr[l-1])/2;
                System.out.println(mid - arr[l-1]);
            }
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        Solution ob = new Solution(scanner);
        while(t-->0){
            ob.solve();
        }

    }
}