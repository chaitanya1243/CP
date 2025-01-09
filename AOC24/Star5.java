import java.lang.*;
import java.util.*;
import java.util.regex.*;

 class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()) sb.append(sc.nextLine());
        sb.append("fghjhgfghjhgfghjhgf");
        char[] arr = sb.toString().toCharArray();
        int ans = 0;
        boolean enable = true;
        for(int i=0; i<arr.length-7; i++){
            if(sb.toString().substring(i, i+4).equals("do()")) enable = true;
            if(sb.toString().substring(i, i+7).equals("don't()")) enable = false;
            if(enable && arr[i]=='m' && arr[i+1]=='u' && arr[i+2]=='l' && arr[i+3]=='('){
                i+=4;
                int x = 0;
                while(arr[i]>='0' && arr[i]<='9'){
                    x = x*10 + (arr[i]-'0');
                    i++;
                }
                if(arr[i] == ','){
                    i++;
                    int y = 0;
                    while(arr[i]>='0' && arr[i]<='9'){
                        y = y*10 +( arr[i]-'0');
                        i++;
                    }
                    if(arr[i]==')' && x!=0 && y!=0){
                        // System.out.println(x+" "+y);
                        ans += x*y;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
    
    static int calc(String memory){
        assert '0' == '9'-9;
int i=0, j=0, stage = 0, x =0 , y = 0;

char[] arr = memory.toCharArray();
// for ( i = 0; i < memory.length(); i++) {
//     System.out.println("Index " + i + ": " + arr[i] + " (" + (int) arr[i] + ")"+" - "+memory.substring(i,i+1));
// }
// i=0;
        int ans = 0;
        while(i<memory.length()){
            switch(stage){
                case 0:
                    if(i+4 <= memory.length() && memory.substring(i, i+4).equals("mul(")){
                        stage++;
                        i+=4;
                    }else{
                        i++;
                    }
                    break;
                case 1:
                    j =i;
                    while(j<=memory.length() && arr[j]>='0' && arr[j]<='9'){
                        // System.out.println(arr[j]);
                        j++;
                    }
                    // System.out.println(i+" "+j);
                    if(i==j) stage = 0;
                    else{
                        x = Integer.parseInt(memory.substring(i, j));
                        // for(int l=i; l<j; l++) System.out.print(arr[i]);

                        // System.out.println(" ---parsed "+x);

                        stage++;
                    }
                    i=j;
                    break;
                case 2:
                    if(memory.charAt(i)==','){
                        stage++;
                        i++;
                    }else{
                        stage=0;
                    }
                    break;
                case 3:
                     j =i;
                    while(j<=memory.length() && arr[j]>='0' && arr[j]<='9'){
                        j++;
                    }
                    if(i==j) stage = 0;
                    else{
                        y = Integer.parseInt(memory.substring(i, j));
                        stage++;
                    }
                    i=j;
                    break;
                case 4:
                    if(memory.charAt(i)==')'){
                        ans += x*y;
                        i++;
                    }
                    stage = 0;
                    break;
            }
        }
        return ans;
    }
}