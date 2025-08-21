import java.util.*;

public final class D12002{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }

    static void solve(Scanner sc){
        int n = sc.nextInt(), q = sc.nextInt();
        Node arr[] = new Node[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new Node(i, null, null);
        }

        for(int i=2; i<=n; i++){
            int f = sc.nextInt();
            arr[i].parent = arr[f];
            arr[f].children.add(i);
        }
        int p[] = new int[n];
        for(int i=0; i<n; i++){
            p[i] = sc.nextInt();
        }

        Node root = createTree(n);
        List<Node> dfsOrder = new ArrayList<>();
        treeInDFS(root, dfsOrder);
        // initial permutation;
        for(int i=0; i<n; i++){
            dfsOrder.get(i).value = p[i];
        }
        // System.out.println(dfsOrder);
        int bads = 0;
        // find initial bads
        bads = badCount(dfsOrder, arr);

        for(int i=0; i<q; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            // effected nodes
            List<Node> o = dfsOrder;
            Node a = o.get(x-1);
            Node b = o.get(y-1);
            Set<Node> l = new HashSet<Node>(List.of(a, b));
            if(!a.isLeaf()){
                l.add(a.left);
                l.add(a.right);
            }
            if(!b.isLeaf()){
                l.add(b.left);
                l.add(b.right);
            }
            int before = badCount(l, arr);
            int tmp = a.value;
            a.value  = b.value;
            b.value = tmp;
            int after = badCount(l, arr);
            // System.out.println(bads+" "+before+" "+after+" ");
            bads += after-before;
            if(bads == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

        // System.out.println(bads);
    }
    static int badCount(Iterable<Node> l, int[] p){
        int bads= 0;
        for(Node i:l){

            int v = i.value;
            if(v==1){
                if(i.parent!=null){
                    bads++;
                }
            }else if(i.parent ==null || i.parent.value != p[v]){
                bads++;
            }
        }
        return bads;
    }
    static void dfs(int[] arr, int r, List<Integer> out){
        out.add(r);
        if(r*2 >= arr.length) return;
        dfs(arr, r*2, out);
        dfs(arr, r*2+1, out);
    }

    static class Node{
        int value;
        List<Node> v;
        Node parent;

        Node(int value, List<Node> v,  Node parent){
            this.value = value;
            this.v = v== null ? new ArrayList<>(): v;
            this.parent = parent;
        }

        public String toString(){

        return value+"";
        }

        boolean isLeaf(){
            return v.isEmpty();
        }
    }

    static Node createTree(int size){
        if(size == 1) return new Node(0, null, null, null);
        Node me = new Node(9, createTree(size/2), createTree(size/2), null);
        me.left.parent = me;
        me.right.parent = me;
        return me;
    }

    static void treeInDFS(Node r, List<Node> order){
        if(r==null) return;
        order.add(r);
        treeInDFS(r.left, order);
        treeInDFS(r.right, order);
    }
}

