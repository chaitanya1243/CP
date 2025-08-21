import java.util.*;

class Solution{
        static char[][] keypad = new char[][]{
            {'7','8','9'},
            {'4','5','6'},
            {'1','2','3'},
            {'.','0','A'},
        };
        static char[][] dirpad = new char[][]{
            {'.','^','A'},
            {'<','v','>'},
        };
        
    static int[][] dirs = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static char[] moves = new char[]{'<','>','v','^'};

    // false - movement, true - keypad press
    static boolean action(Character mv, int i, List<Character> state) throws Exception{
        if(mv=='A'){
            // last robot (keypad)
            if(i==2) {
                return true;
            }else{
                return action(state.get(i), i+1, state);
            }
        }
        char[][] pad = i==2? keypad : dirpad;
        int n = pad.length, m = pad[0].length;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(pad[r][c]==state.get(i)){
                    var d = dirOf(mv);
                    int x = r+d[0], y = c+d[1];
                    if(x>=0 && x<n && y>=0 && y<m && pad[x][y]!='.'){

                        state.set(i, pad[r+d[0]][c+d[1]]);
                        return false;
                    }
                    else{
                        throw new Exception("");
                    }
                }
            }
        }
        return false;
    }

    static class State{
        int dist;
        List<Character> rState;
        int prog;
        State(List<Character> rState, int dist, int prog){
            this.dist = dist;
            this.rState = rState;
            this.prog =  prog;
        }

        public int hashCode(){
            return Objects.hash(prog, rState);
        }
        
        public boolean equals(Object other){
            var o = (State) other;
            return rState.equals(o.rState) && prog == o.prog;
        }

        public String toString(){
            return rState.toString()+" "+dist+" "+prog;
        }
    }

    static int solve(String str){
        Queue<State> q =  new LinkedList<>();
        q.add(new State(List.of('A','A','A'), 0, 0));
        Set<State> v = new HashSet<>();
        v.add(new State(List.of('A','A','A'), 0, 0));
        while(q.size()>0){

            var c = q.poll();
            // System.out.println(c);
            for(var mv : List.of('<','>','v','^','A')){
                var newState = new ArrayList<Character>(c.rState);
                try{
                    var digitPressed = action(mv, 0, newState);
                    if(digitPressed){
                        if(str.charAt(c.prog)==newState.get(2)){
                            if(newState.get(2)=='A' || c.prog+1==str.length()){
                                return c.dist+1;
                            }else{
                                q.add(new State(newState, c.dist+1, c.prog+1));
                                v.add(new State(newState, c.dist+1, c.prog+1));
                            }
                        }
                    }else{
                        var ns = new State(newState, c.dist+1, c.prog);
                        if(v.contains(ns)) continue;
                        q.add(ns);
                        v.add(ns);
                    }
                }catch (Exception e){
                    // pass
                }
            }
        }
        return 0;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // while( sc.hasNext()){
        //     map.add(sc.nextLine().toCharArray());
        // }

        //
        // find all possible min length paths
        // min??
        /// <A
        /// v<<A>>^A
        /// v<A<AA>>^AvAA^<A>A
        /// v<A -> v<A<A>>^A
        /// <vA -> v<<A>A>^A
        /// <V<A -> v<<A>A<A>>^A
        /// v<<A -> v<A<AA>>^A
        // String str = "980A";
        // // System.out.println(solve(str));

        //         int ans=0;
        // while( sc.hasNext()){
        //    var line = sc.nextLine();
        //    int inp = Integer.parseInt(line.substring(0, 3));
        //    ans+= inp*solve(line);
        // }
        System.out.println(solve("8"));


        // HashMap<String, String> keypadDP = new HashMap<>(); //dist
        // for(int i=0; i<4; i++){
        //     for(int j=0; j<3; j++){
        //         Set<Node> q = new HashSet<>();
        //         q.add(new Node(i, j, ""));
        //         keypadDP.put(keypad[i][j]+""+keypad[i][j], "");
        //         while(q.size()>0){
        //             // if(keypad[i][j]=='7') System.out.println(q);
        //             var c = q.iterator().next();
        //             q.remove(c);
        //             int cx = c.x, cy = c.y;

        //             for(int d=0; d<4; d++){
        //                 int x = cx+dirs[d][0], y = cy+dirs[d][1];
        //                 if(x>=0 && x<4 && y>=0 && y<3 && keypad[x][y]!='.'){
        //                     String key = keypad[i][j]+""+keypad[x][y];
        //                     var existing = keypadDP.get(key);
        //                     var maybe = c.path+syms[d];
        //                     if(existing == null){
        //                         q.add(new Node(x, y, maybe));
        //                         keypadDP.put(key, maybe);
        //                     }else{
        //                         if(existing.length() > maybe.length()){
        //                             q.remove(new Node(x, y, existing));
        //                             q.add(new Node(x, y, maybe));
        //                             keypadDP.put(key, maybe);
        //                         }else if (existing.length() == maybe.length()){
        //                             // if(key.equals("70")){
        //                             //     System.out.println(existing);
        //                             //     System.out.println(maybe);
        //                             // }
        //                             if(turns(maybe) <= turns(existing)){
        //                                 q.add(new Node(x, y, maybe));
        //                                 keypadDP.put(key, maybe);
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // HashMap<String, String> dirpadDP = new HashMap<>();
        // for(int i=0; i<2; i++){
        //     for(int j=0; j<3; j++){
        //         Set<Node> q = new HashSet<>();
        //         q.add(new Node(i, j, ""));
        //         dirpadDP.put(dirpad[i][j]+""+dirpad[i][j], "");
        //         while(q.size()>0){
        //             // if(keypad[i][j]=='7') System.out.println(q);
        //             var c = q.iterator().next();
        //             q.remove(c);
        //             int cx = c.x, cy = c.y;

        //             for(int d=0; d<4; d++){
        //                 int x = cx+dirs[d][0], y = cy+dirs[d][1];
        //                 if(x>=0 && x<2 && y>=0 && y<3 && dirpad[x][y]!='.'){
        //                     String key = dirpad[i][j]+""+dirpad[x][y];
        //                     var existing = dirpadDP.get(key);
        //                     var maybe = c.path+syms[d];
        //                     if(existing == null){
        //                         q.add(new Node(x, y, maybe));
        //                         dirpadDP.put(key, maybe);
        //                     }else{
        //                         if(existing.length() > maybe.length()){
        //                             q.remove(new Node(x, y, existing));
        //                             q.add(new Node(x, y, maybe));
        //                             dirpadDP.put(key, maybe);
        //                         }else if (existing.length() == maybe.length()){
        //                             // if(key.equals("70")){
        //                             //     System.out.println(existing);
        //                             //     System.out.println(maybe);
        //                             // }
        //                             if(turns(maybe) <= turns(existing)){
        //                                 q.add(new Node(x, y, maybe));
        //                                 dirpadDP.put(key, maybe);
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }

        // int ans=0;
        // while( sc.hasNext()){
        //    var line = sc.nextLine();
        //    int inp = Integer.parseInt(line.substring(0, 3));
        //    line = 'A'+line;
        //    String forR1 ="";
        //    for(int i=1; i<line.length(); i++){
        //         forR1+= keypadDP.get(line.substring(i-1, i+1))+"A";
        //    }
        //    for(int x=0; x<2; x++){
        //     System.out.println(forR1);
        //     line = 'A'+forR1;
        //     forR1 = "";
        //     for(int i=1; i<line.length(); i++){
        //         forR1+= dirpadDP.get(line.substring(i-1, i+1))+"A";
        //     }
        //    }
        //     System.out.println(forR1);
        //     ans+= forR1.length()*inp;
        //    }

        // // System.out.println(forR2);
        
        // System.out.println(ans);
        // System.out.println(dirPadOperate("<A>Av<<AA>^AA>AvAA^A<vAAA>^A"));
    }

    static int[] dirOf(char c){
        for(int i =0; i<4; i++){
            if(moves[i]==c) return dirs[i];
        }
        return null;
    }
    static String dirPadOperate(String s){
        int x =0, y=2;
        String out = "";
        for(char c: s.toCharArray()){
            if(c=='A'){
                out+=dirpad[x][y];
                continue;
            }
            var d = dirOf(c);
            x+=d[0];
            y+=d[1];

        }
        return out;
    }

    static int turns(String s){
        int t = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                t++;
            }
        }
        return t;
    }
}

class Node{
    int x, y;
    String path;
    Node(int x, int y, String path){
        this.x = x;
        this.y = y;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        Node other = (Node)o;
        return x==other.x && y==other.y && path==other.path;
    }   

    @Override
    public int hashCode() {
        return path.hashCode() + (x*3+y);
    }

        @Override
    public String toString() {
        return path;
    }
}