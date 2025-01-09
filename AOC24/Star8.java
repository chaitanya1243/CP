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
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if(isSM(arr[i][j], arr[i+2][j+2]) && isSM(arr[i][j+2], arr[i+2][j]) && arr[i+1][j+1]=='A') count++;
            }
        }

     
        System.out.println(count);
    }
    static boolean isSM(char i, char j){
        return (i=='M'&&j=='S') ||( i=='S'&&j=='M');
    }
}

// xmas
// samx