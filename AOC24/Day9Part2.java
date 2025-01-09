import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        long ans = 0;
        List<PriorityQueue<Integer>> ds = new ArrayList<>(10);
        for(int i=0; i<10; i++) ds.add(new PriorityQueue<>());
        List<Block> bs = new ArrayList<>();
        for(int i=0, p=0; i<line.length(); i++){
            int x = line.charAt(i)-'0';
            if(i%2==1){
                ds.get(x).offer(p);
            }else{
                bs.add(new Block(i/2, x, p));
            }
            p+=x;
        }
        int MPOS = bs.get(bs.size()-1).pos+10;
        for(int i=bs.size()-1; i>=0; i--){
            int minPos = MPOS, size = 0;
            Block b = bs.get(i);
            for(int j=b.size; j<10; j++){
                var pq = ds.get(j);
                if(pq.size()>0 && pq.peek()<b.pos && pq.peek() < minPos){
                    minPos = pq.peek();
                    size = j;
                }
            }
            if(minPos == MPOS){
                for(int z=0; z<b.size; z++){
                    ans+=b.id*(b.pos+z);
                }
            }else{
                int space = ds.get(size).poll();
                ds.get(size-b.size).offer(space+b.size);
                for(int z=0; z<b.size; z++){
                    ans+=b.id*(space+z);
                }
            }
        }
        // for(int i=0, j=line.length()-1, p=0, rl=line.charAt(line.length()-1)-'0'; i<j; i++){
        //     int id = i/2;
        //     int length = line.charAt(i)-'0';
        //     for(int x =0; x<length; x++, p++){
        //         ans+= p*id;
        //         // System.out.print(id);
        //     }
        //     //space
        //     id = j/2;
        //     length = line.charAt(++i)-'0';
        //     for(int x =0; x<length; x++, p++,rl--){
        //         if(rl==0){
        //             j-=2;
        //             if(j<i) break;
        //             id=j/2;
        //             rl = line.charAt(j)-'0';
        //         }
        //         ans+= p*id;
        //         // System.out.print(id);
        //     }
        //     if(i+1==j){
        //         for(int x =0; x<rl; x++, p++){
        //             ans+= p*id;
        //         // System.out.print(id);
        //         }
        //     }
        // }
        System.out.println(ans);
    }
}

class Block{
    int id;
    int size;
    int pos;
    Block(int id, int size, int pos){
        this.id = id;
        this.size = size;
        this.pos = pos;
    }
}