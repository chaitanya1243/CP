import java.util.*;

class Solution{

    static Map<String, Node> nodes;
    static List<String> ans = new ArrayList<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        nodes = new HashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            var c = line.split("-");
            String a = c[0], b = c[1];
            nodes.putIfAbsent(a, new Node(c[0]));
            nodes.putIfAbsent(b, new Node(c[1]));
            nodes.get(a).connections.add(nodes.get(b));
            nodes.get(b).connections.add(nodes.get(a));
            nodes.get(a).list.add(nodes.get(b));
            nodes.get(b).list.add(nodes.get(a));

        }

        // System.out.println(nodes);
        // Set<String> done = new HashSet<>();
        // int ans = 0;
        // for(var kv: nodes.entrySet()){
        //     if(kv.getKey().charAt(0)=='t'){
        //         List<Node> cs = new ArrayList<>(kv.getValue().connections);
        //         for(int i=0; i<cs.size()-1; i++){
        //             if(done.contains(cs.get(i).v)) continue;
        //             for(int j=i+1; j<cs.size(); j++){
        //                 if(done.contains(cs.get(j).v)) continue;
        //                 if(cs.get(i).connections.contains(cs.get(j))){
        //                     ans++;
        //                     // System.out.println(kv.getKey()+cs.get(i).v+cs.get(j).v);
        //                 }
        //             }
        //         }
        //         done.add(kv.getKey());
        //     }
        // }
        for(var e: nodes.entrySet()){
            var l = new ArrayList<String>();
            l.add(e.getKey());
            rec(e.getKey(), 0,l);
        }
        Collections.sort(ans);
        System.out.println(ans);
    }

    static void rec(String s, int i, List<String> clique){
        if(i >= nodes.get(s).connections.size()){
            if(clique.size() > ans.size()){
                ans = clique;
            }
            return;
        }
        rec(s, i+1, clique);
        var nodeb = nodes.get(s).list.get(i);
        // var nodeb = new Node(b);
        boolean all = true;
        for(var c: clique){
            if(!nodes.get(c).connections.contains(nodeb)){
                return;
            }
        }
        // if(all)
        clique.add(nodeb.v);
        rec(s, i+1, clique);
        // if(all)
        // clique.removeLast();
    }
}
class Node{
    String v;
    Set<Node> connections = new HashSet<>();
    List<Node> list = new ArrayList<>();
    Node(String v){
        this.v = v;
    }

    public int hashCode() {
        return v.hashCode();
    }

    public boolean equals(Object other){
        return v==((Node)other).v;
    }

    public String toString(){
        String c = "";
        for(var v: connections){
            c+=v.v+",";
        }
        return "["+v+"] "+c+";";
    }
}