import java.util.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) {
        Pattern buttonAP = Pattern.compile("Button A: X\\+([0-9]+), Y\\+([0-9]+)");
        Pattern buttonBP = Pattern.compile("Button B: X\\+([0-9]+), Y\\+([0-9]+)");
        Pattern prizeP = Pattern.compile("Prize: X=([0-9]+), Y=([0-9]+)");

        String line = "";
        long ans = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            line = sc.nextLine();
            while (sc.hasNext() && line.isEmpty()) line = sc.nextLine();

            var m1 = buttonAP.matcher(line);
            m1.find();
            int ax = Integer.parseInt(m1.group(1));
            int ay = Integer.parseInt(m1.group(2));

            var m2 = buttonBP.matcher(sc.nextLine());
            m2.find();
            int bx = Integer.parseInt(m2.group(1));
            int by = Integer.parseInt(m2.group(2));

            var m3 = prizeP.matcher(sc.nextLine());
            m3.find();
            long px = Integer.parseInt(m3.group(1));
            px+=+10000000000000l;
            long py = Integer.parseInt(m3.group(2));
            py+=+10000000000000l;

            // System.out.println(costAX+" "+costBX+" "+costAY+" "+ costBY+" "+prizeX+" "+prizeY);

            // int dp[][] = new int[prizeX+1][prizeY+1];
            // for(var i: dp) Arrays.fill(i, -1);
            // int x = min(costAX, costAY, costBX, costBY, prizeX, prizeY, dp);
            // ans += x==-2?0:x;

            long j = (ax*py-ay*px)/(by*ax-ay*bx);
            long i = (bx*py-by*px)/(-by*ax+ay*bx);
            if(i*ax+j*bx==px){
                if(i*ay+j*by==py){
                    ans+=i*3+j;
                }
            }
        }
        System.out.println(ans);
    }

    static int min(int cax, int cay, int cbx, int cby, int tx, int ty, int[][] dp) {
        if (tx == 0 && ty == 0) return 0;
        if (tx < 0 || ty < 0) return -2;
        if(dp[tx][ty]!=-1) return dp[tx][ty];
        int oa = min(cax, cay, cbx, cby, tx - cax, ty - cay, dp);
        int ob = min(cax, cay, cbx, cby, tx - cbx, ty - cby, dp);
        int ans = 0;
        if(oa==-2 && ob==-2)  ans = -2;

        else if(oa==-2)  ans = ob+1;
        else if(ob==-2)  ans =oa+3;
        else ans = Math.min(oa+3, ob+1);

        return dp[tx][ty] = ans;
    }
}
