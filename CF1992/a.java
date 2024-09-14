import java.io.*;
import java.uitl.*;

public final class a{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int k = 5;
        while(k>0){
            int avg = (a+b+c)/3;
            if(a < avg){
                a++;
            }else if(b < avg){
                b++;
            }else if(c < avg){
                c++;
            }else{
                
            }
            
        }
    }
}