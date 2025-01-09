import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(sc.hasNext()) list.add(sc.nextLine());
        int n = list.size(), m = list.get(0).length();
        char[][] arr = new char[n][m];
        for(int i=0; i<n; i++) arr[i] = list.get(i).toCharArray();
        int count =0;
        // horizontal
        for(int i=0; i<n; i++){
            for(int j=0; j<m-3; j++){
                if(arr[i][j]=='X' && arr[i][j+1]=='M' &&arr[i][j+2]=='A' &&arr[i][j+3]=='S') count++;
                if(arr[i][j]=='S' && arr[i][j+1]=='A' &&arr[i][j+2]=='M' &&arr[i][j+3]=='X') count++;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n-3; j++){
                if(arr[j][i]=='X' && arr[j+1][i]=='M' &&arr[j+2][i]=='A' &&arr[j+3][i]=='S') count++;
                if(arr[j][i]=='S' && arr[j+1][i]=='A' &&arr[j+2][i]=='M' &&arr[j+3][i]=='X') count++;
            }
        }

        for(int d=3; d<n; d++){
            for(int i=d, j=0; i>=3; i--,j++){
                if(arr[i][j]=='X' && arr[i-1][j+1]=='M' &&arr[i-2][j+2]=='A' &&arr[i-3][j+3]=='S') count++;
                if(arr[i][j]=='S' && arr[i-1][j+1]=='A' &&arr[i-2][j+2]=='M' &&arr[i-3][j+3]=='X') count++;
            }
        }
        for(int d=1; d<m-3; d++){
            for(int i=n-1, j=d; j<m-3; i--,j++){
                if(arr[i][j]=='X' && arr[i-1][j+1]=='M' &&arr[i-2][j+2]=='A' &&arr[i-3][j+3]=='S') count++;
                if(arr[i][j]=='S' && arr[i-1][j+1]=='A' &&arr[i-2][j+2]=='M' &&arr[i-3][j+3]=='X') count++;
            }
        }
        for(int d=m-4; d>=0; d--){
            for(int j=d, i=0; j<m-3; i++,j++){
                if(arr[i][j]=='X' && arr[i+1][j+1]=='M' &&arr[i+2][j+2]=='A' &&arr[i+3][j+3]=='S') count++;
                if(arr[i][j]=='S' && arr[i+1][j+1]=='A' &&arr[i+2][j+2]=='M' &&arr[i+3][j+3]=='X') count++;
            }
        }
        for(int d=1; d<n-3; d++){
            for(int i=d, j=0; i<n-3; i++,j++){
                if(arr[i][j]=='X' && arr[i+1][j+1]=='M' &&arr[i+2][j+2]=='A' &&arr[i+3][j+3]=='S') count++;
                if(arr[i][j]=='S' && arr[i+1][j+1]=='A' &&arr[i+2][j+2]=='M' &&arr[i+3][j+3]=='X') count++;
            }
        }
        System.out.println(count);
    }
}

// xmas
// samx