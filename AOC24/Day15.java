import java.util.*;
import java.util.regex.*;

class Solution {
    static int x, y=0;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<char[]> map = new ArrayList<>();
        String line = "";
        // int x = 0, y =0;
        while(!(line = sc.nextLine()).isEmpty()){
            map.add(line.toCharArray());
        }
        int n = map.size(), m = map.get(0).length;
        char[][] map2 = new char[n][m*2];
        // for(int i)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char c = map.get(i)[j];
                if(c=='@'){
                    x =i;
                    y =j*2;
                    map2[x][y]='@';
                    map2[x][y+1]='.';
                }else if(c=='O'){
                    map2[i][j*2]='[';
                    map2[i][j*2+1]=']';
                }
                else{
                    map2[i][j*2]=c;
                    map2[i][j*2+1]=c;
                }
            }
        }

        while(sc.hasNext()){
            line = sc.nextLine();
            for(var c: line.toCharArray()){
                // System.out.print(c);
                int[] dir = null;
                switch(c){
                    case '>':
                        dir = new int[]{0, 1};
                        if(canMove(x, y+1, map2, dir)){
                            move(x, y+1, map2, dir);
                            map2[x][y]='.';
                            y++;
                            map2[x][y]='@';
                        }
                        break;
                    case 'v':
                        dir = new int[]{1,0};
                        if(canMove(x, y, map2, dir)){
                            move(x, y, map2, dir);
                            x++;
                        }
                        break;
                    case '<':
                         dir = new int[]{0, -1};
                        if(canMove(x, y-1, map2, dir)){
                            move(x, y-1, map2, dir);
                            map2[x][y]='.';
                            y--;
                            map2[x][y]='@';
                        }
                        break;
                    case '^':
                         dir = new int[]{-1, 0};
                        if(canMove(x, y, map2, dir)){
                            move(x, y, map2, dir);
                            x--;
                        }
                        break;
                }
                // pr(map2);
                // break;
            }
        }
                pr(map2);

        int ans = 0;
        for(int i=0; i<map2.length; i++){
            for(int j=0; j<map2[0].length; j++){
                if(map2[i][j]=='['){
                    ans += ((i)*100)+j;
                }
            }
        }
        System.out.println(ans);
    }
    static boolean canMove(int i, int j, char[][] map, int[] dir){
        int x = dir[0], y = dir[1];
        // if(map[i+x][j+y]=='#') return false;
        // if(map[i+x][j+y]=='.') return true;
        if(map[i][j]=='#') return false;
        if(map[i][j]=='.') return true;
        if(x==0){
            return canMove(i, j+2*y, map, dir);
        }
        char wtf = map[i+x][j];
        boolean c = canMove(i+x, j, map, dir);
        if(wtf=='[') return c && canMove(i+x, j+1, map, dir);
        if(wtf==']') return c && canMove(i+x, j-1, map, dir);
        return c;
    }
    static void move(int i, int j, char[][] map, int[] dir){
        int x = dir[0], y = dir[1];
        // if(map[i+x][j+y]=='#') return false;
        // if(map[i+x][j+y]=='.') return true;
        assert map[i][j]!='#';

        if(map[i][j]=='.') return;
        if(x==0){
            move(i, j+2*y, map, dir);
            map[i][j+2*y]= map[i][j+y];
            map[i][j+y] = map[i][j];
            map[i][j]='.';
            return;
        }
        char wtf = map[i+x][j];
        move(i+x, j, map, dir);
        if(wtf=='[') {
            // System.out.println(
            // "Wt"
            // );
            move(i+x, j+1, map, dir);
        }
        if(wtf==']') {
            // System.out.println(
            // "Wt"
            // );
            move(i+x, j-1, map, dir);
        }

        map[i+x][j] = map[i][j];
        map[i][j]='.';
        
    }
    static void pr(char[][] map){
        for(var cs: map){
            for(var c: cs){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    // static void move(int i, int j, int l, char[][] map, int[] dir){
    //     // int n = map.length, m = map.get(0).length;
    //         // System.out.println(i+" "+j);
    //     for(int m=j; m<l;m++){
    //         if(map[i][m]=='#') return;
    //     }
    //     boolean ok=true;
    //     for(int m=j; m<l; m++){
    //         if(map[i][m]!='.') ok=false;
    //     }
    //     if(ok) return;
        
    //     move(i+dir[0], j+dir[1], map, dir);
    //     if(map[i][j]=='[')
    //         move(i+dir[0], j+dir[1], map, dir);
    //     if(map.get(i+dir[0])[j+dir[1]]=='.'){
    //         if(map[i][j]=='@'){
    //             x+=dir[0];
    //             y+=dir[1];
    //         }
    //         map.get(i+dir[0])[j+dir[1]] = map[i][j];
    //         map[i][j] = '.';
    //     }
    // }
}