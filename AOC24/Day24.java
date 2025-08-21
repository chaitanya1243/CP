import java.util.*;
import java.util.regex.*;


class Solution{

    static HashMap<String, Boolean> map = new HashMap<>();
    static HashMap<String, List<Op>> ds = new HashMap<>();
    static List<Op> opList = new ArrayList<>();

    static long simulate(long x, long y){
        setup(x, y);
        var list = new ArrayList<String>(map.keySet());
        var newMap = new HashMap<String, Boolean>(map);
        for(int i=0; i<list.size(); i++){
            var c  = list.get(i);
            if(ds.containsKey(c))
            for(var u : ds.get(c)){
                if(newMap.containsKey(u.left) && newMap.containsKey(u.right) && !newMap.containsKey(u.out)){
                    var r = operate(u, newMap);
                    newMap.put(u.out, r);
                    list.add(u.out);
                }
            }
        }
        Collections.sort(list);
        long ans = 0;
        // System.out.println(list);
        // System.out.println(map);

        for(int i=0; i<list.size(); i++){
            if(list.get(i).charAt(0)=='z'){
                for(int j=0; j+i<list.size(); j++){
                    ans += (newMap.get(list.get(j+i))?1l:0l) << j;
                }
                break;
            }
        }
        return ans;
    }
    static void setup(long x, long y){

        for(int i=0; i<=44; i++){
            long d = 1l<<i;
            map.put("x"+(i<10?"0":"")+i, (x&d)==d);
            map.put("y"+(i<10?"0":"")+i, (y&d)==d);
        // System.out.println("x"+(i<10?"0":"")+i+((x&d)==d));

        }
        // System.out.println(map);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        var p1 =  Pattern.compile("(.*): (\\d)");
        var p2 =  Pattern.compile("(.*) (.*) (.*) -> (.*)");
        String line;
        while(!(line=sc.nextLine()).isEmpty()){
            var m = p1.matcher(line);
            m.find();
            map.put(m.group(1), m.group(2).equals("1"));
        }
        while(sc.hasNext()){            
            var m = p2.matcher(sc.nextLine());
            m.find();
            var o = new Op(m.group(1), m.group(3), m.group(2), m.group(4));
            if(!ds.containsKey(o.left)) ds.put(o.left, new ArrayList<>());
            if(!ds.containsKey(o.right)) ds.put(o.right, new ArrayList<>());
            ds.get(o.left).add(o);
            ds.get(o.right).add(o);
            opList.add(o);
        }

                // swap(opList.get(77), opList.get(130));
                // swap(opList.get(94), opList.get(217));
                // swap(opList.get(124), opList.get(169));
                // swap(opList.get(8), opList.get(159));

                List<String> ans = new ArrayList<>();
                for(int i: List.of(77,130,94,217,124,169,8,159)){
                   ans.add( opList.get(i).out);
                }
                Collections.sort(ans);
                System.out.println(ans);
        // swap(42, 77);

        // for(int i=0;  i<opList.size();i++){
        //             System.out.println(i);
        //     for(int j=i+1; j<opList.size(); j++){
        //         swap(opList.get(i), opList.get(j));
        //         boolean ok=true;
        //         for(int k=0; k<35 && ok; k++){
        //             long x = 1l<<k;
        //             if(simulate(x, x) != 2*x || (x>0 && simulate(x-1, x+1)!=2*x)){
        //                 ok=false;
        //             }
        //         }
        //         if(ok){
        //             System.out.println("["+i+" "+j+"]");
        //             // return;
        //         }
        //         swap(opList.get(j), opList.get(i));
        //     }
        // }

        // for(int i=1; i<20; i++){
        //     // long x = (i << 10 + i) << 10 + i;
        //     // l
        //     long x =(long)( Math.random() * (1l << 44));
        //     System.out.println(i);
        //     compare(simulate(x, x), 2*x);
        //     // break;
        //     // System.out.println(simulate(0,0));
        // }

    //    long x =simulate(0, 0);
    //    System.out.println(x);
    }
    static void compare(long x, long y){
        for(int i=0; i<=45; i++){
            if((x& (1<<i))==(y& (1<<i))){
                System.out.print('.');
            }else{
                System.out.print('X');
            }
        }
        System.out.println();
    }

    static void swap(Op a, Op b){
        var tmp = a.out;
        a.out = b.out;
        b.out = tmp;
    }

    static boolean operate(Op op, HashMap<String, Boolean> map){
        boolean a = map.get(op.left), b = map.get(op.right);
        boolean r = false;
        switch(op.operand){
            case "AND":
                r = a & b;
                break;
            case "OR":
                r = a |b;
                break;
            case "XOR":
                r = a ^ b;
                break;
        }
        return r;
    }



    static class Op{
        String left,  right;
        String operand;
        String out;
        Op(String  left, String right, String operand, String out){
            this.left = left;
            this.right = right;
            this.operand = operand;
            this.out = out;
        }
    }

    

}