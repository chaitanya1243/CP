import java.util.*;
public final class C1537{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
    static final Random random=new Random();
    static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
    static void solve(Scanner sc){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        ruffleSort(arr);
        int min = arr[1]-arr[0];
        int minIdx  = 0;
        for(int i=0; i<n-1; i++){
            if(arr[i+1]-arr[i]<min){
                min = arr[i+1] -arr[i];
                minIdx = i;
            }
        }
        int[] sol = new int[n];
        sol[0] = arr[minIdx];
        sol[n-1] = arr[minIdx+1];
        for(int i=minIdx+2, j=1; i<n; i++, j++){
            sol[j] = arr[i];
        }
        for(int i=0, j=n-minIdx-1; i<minIdx; i++, j++){
            sol[j] = arr[i];

        }
        for(int i:sol)
        System.out.print(i+" ");
        System.out.println();
    }
}