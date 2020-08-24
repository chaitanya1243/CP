import java.util.*;
// 11202191222742
class Solution
{
    public static void main(String argas[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int ti=1; ti<=T; ti++){
            int n = in.nextInt();
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            boolean flag = true;
            StringBuilder ans = new StringBuilder();
            if(a!=1 && b!=1){
                int left = a-c;
                int right = n+1-(b-c);
                // System.out.println(left+" "+right);
                if(right - left <= c)
                flag = false;
                else{
                    a -= c;
                    b -= c;
                    int arr[] = new int[n+1];
                    for(int i=1; i<=a; i++){
                        arr[i] = n-1;
                    }
                    for(int i=n; i>n-b; i--){
                        arr[i] = n-1;
                    }
                    for(int i=0; i<c; i++){
                        arr[++left] = n;
                    }
                    for(int i=0; i<=n; i++){
                        if(arr[i]==0)
                        arr[i] = n-2;
                    }
                    for(int i=1; i<=n; i++)
                    ans.append(arr[i]+" ");
                }

            }else{
                if(a==b)
                flag = false;
                else if(a==1){
                    int arr[] = new int[n+1];
                    arr[1] = n;
                    for(int i=n; i>n-b+1; i--){
                        arr[i] = n-1;
                    }
                    for(int i=0; i<=n; i++){
                        if(arr[i]==0)
                        arr[i] = n-2;
                    }
                    for(int i=1; i<=n; i++)
                    ans.append(arr[i]+" ");
                }else{
                    int arr[] = new int[n+1];
                    arr[n] = n;
                    for(int i=1; i<a; i++){
                        arr[i] = n-1;
                    }
                    for(int i=0; i<=n; i++){
                        if(arr[i]==0)
                        arr[i] = n-2;
                    }
                    for(int i=1; i<=n; i++)
                    ans.append(arr[i]+" ");
                }
            }
            System.out.println("Case #"+ti+": "+(flag?ans:"IMPOSSIBLE"));
        }
    }
}