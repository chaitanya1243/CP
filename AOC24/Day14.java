import java.util.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)");

        String line = "";
        long ans = 0;
        int q1=0, q2=0, q3=0, q4=0;
        Scanner sc = new Scanner(System.in);
            int w = 101, h =103;
        HashMap<List<Integer>, List<Integer>> hm = new HashMap<>();

        while (sc.hasNext()) {
            line = sc.nextLine();
            Matcher m = p.matcher(line);
            m.find();

            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            int dx = Integer.parseInt(m.group(3));
            int dy = Integer.parseInt(m.group(4));
            hm.put(List.of(x,y), List.of(dx, dy));

            // if(x < w/2 && y < h/2) q1++;
            // else if(x > w/2 && y > h/2) q4++;
            // else if(x > w/2 && y < h/2) q2++;
            // else if(x < w/2 && y > h/2) q3++;
        }
        int sec = 1;
        while(true){
            boolean[][] out = new boolean[h][w];
            for(var e: hm.entrySet()){
                int x = e.getKey().get(0), y = e.getKey().get(1);
                int dx = e.getValue().get(0), dy = e.getValue().get(1);

                x = dx*sec+x;
                x = (x%w + w)%w;
                // x = (x%11 + 11)%11;
                y = dy*sec+y;
                y = (y%h + h)%h;
                // y = (y%7 + 7)%7;
                out[y][x] = true;
            }
            int m =0;
            for(int i=0; i<h-1; i++){
                for(int j=1; j<w-1; j++){
                    if(out[i][j] && out[i+1][j+1])m++;
                    if(out[i][j] && out[i+1][j-1])m++;
                }
            }
            if(m>150)
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(out[i][j]) System.out.print("X");
                    else System.out.print(".");

                }
                System.out.println();
            }
            System.out.println(sec);

            sec++;
        }
        // System.out.println(q1*q2*q3*q4);
        // System.out.println(q1+" "+q2+" "+q3+" "+q4);
    }
}
