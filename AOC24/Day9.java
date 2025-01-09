import java.util.*;
class Solution
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        long ans = 0;
        for(int i=0, j=line.length()-1, p=0, rl=line.charAt(line.length()-1)-'0'; i<j; i++){
            int id = i/2;
            int length = line.charAt(i)-'0';
            for(int x =0; x<length; x++, p++){
                ans+= p*id;
                // System.out.print(id);
            }
            //space
            id = j/2;
            length = line.charAt(++i)-'0';
            for(int x =0; x<length; x++, p++,rl--){
                if(rl==0){
                    j-=2;
                    if(j<i) break;
                    id=j/2;
                    rl = line.charAt(j)-'0';
                }
                ans+= p*id;
                // System.out.print(id);
            }
            if(i+1==j){
                for(int x =0; x<rl; x++, p++){
                    ans+= p*id;
                // System.out.print(id);
                }
            }
        }
        System.out.println(ans);
    }
}