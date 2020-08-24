import java.util.*;

class C
{
    Scanner in = new Scanner(System.in);
    String ans;
    int cost = Integer.MAX_VALUE, n;
    String[] words;
    int costs[], seqId[];
    ArrayList<int[]> seqs;
    void solve(){
        para = in.nextLine().split(" ");
        in.nextLine();
        String s = in.nextLine();

        n = s.length()/2+1;
        char[] keys = new char[n];
        for(int i=0; i<s.length(); i+=2)
        keys[i/2]=s.charAt(i);

        bt(keys, 1, new int[26]);
        System.out.print(ans);
    }
    void bt(char[] keys, int pos, int map[]){
        if(pos>n){
            int prCost = 0;
            for(int i=0; i<para.length; i++){
                if(para[i]!=' ' && map[para[i]-'a']>0){
                    if(i==0 || 
                    para[i-1] ==' ' || 
                    map[para[i]-'a']-map[para[i-1]-'a'] != 1 || 
                    map[para[i-1]-'a']==0)
                    prCost++;
                }
            }
            if(prCost<=cost){
                char[] nc = new char[n];
                for(int i=0; i<26; i++){
                    if(map[i]>0){
                        nc[map[i]-1] = (char)(i+'a');
                    }
                }
                String na = new String(nc);
                if(prCost<cost)
                ans = na;
                else if(na.compareTo(ans)<0)
                ans = na;
                cost = prCost;
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(keys[i]==' ') continue;
            char c = keys[i];
            keys[i]=' ';
            map[c-'a'] = pos;
            bt(keys, pos+1, map);
            map[c-'a']=0;
            keys[i]=c;
        }
    }
    public static void main(String args[]){
        new C().solve();
    }
}