import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String line = "";
        List<List<Integer>> rules = new ArrayList<>(100);
        for(int i=0; i<100; i++) rules.add(new ArrayList<>());
        while(sc.hasNext() && !(line = sc.nextLine()).trim().equals("")){
            rules.get(Integer.parseInt(line.substring(0, 2))).add(Integer.parseInt(line.substring(3,5)));
        // System.out.println(line);
        }
        int ans =0;
        // System.out.println(Arrays.toString(rules));

        while(sc.hasNext()){
            line = sc.nextLine();
            String[] updates = line.split(",");
            int[] vals = new int[updates.length];
            for(int i=0; i<vals.length; i++) vals[i] = Integer.parseInt(updates[i]);
            int[] pos = new int[100];
            // for(int i=0; i<updates.length; i++) set.add(Integer.parseInt(updates[i]));
            boolean incorrect = false;
            main:for(int i=0; i<updates.length; i++){
                int childMinPos = 100;
                while((childMinPos = minIncorrectPos(rules.get(vals[i]), pos))!=100){
                    incorrect = true;
                    childMinPos--; // extra
                    int tmp = vals[i];
                    vals[i] = vals[childMinPos];
                    pos[vals[i]] = i+1;
                    vals[childMinPos] = tmp;
                    pos[vals[childMinPos]] = childMinPos+1;
                }
                pos[vals[i]]=i+1;
            }
        // System.out.println(Arrays.toString(vals));
            if(incorrect)
                ans+=vals[vals.length/2];
        }
        System.out.println(ans);
    }
    static int minIncorrectPos(List<Integer> children, int[] posMap){
        int min = 100;
        for(int child : children){
            if(posMap[child]!=0) min = Math.min(min, posMap[child]);
        }
        return min;
    }
}

// xmas
// samx