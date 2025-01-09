import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);
        // long ans = 0;
        // while(sc.hasNext()){
        //     String line = sc.nextLine();
        //     Scanner nsc = new Scanner(line);
        //     long target = nsc.nextLong();
        // System.out.println(target);
        //     List<Long> li = new ArrayList<>();
        //     // c.add(0l);
        //     // boolean readT
        //     for(int i = 0; i<line.length(); i++){
        //         long x = 0;
        //         if(target==0){
        //             while(i< line.length() && Character.isDigit(line.charAt(i))){
        //                 x = x*10 + (line.charAt(i)-'0');
        //                 i++;
        //             }
        //             target = x;
        //         }else{
        //             while(i< line.length() &&  Character.isDigit(line.charAt(i))){
        //                 x = x*10 + (line.charAt(i)-'0');
        //                 i++;
        //             }
        //             // for(var j: new ArrayList<>(c)){
        //             //     if(j*x <= target) c.add(j*x);
        //             //     if(j+x <= target) c.add(j+x);
        //             //     long bb = make(j, x, target);
        //             //     if(bb!=-1) c.add(bb);
        //             // }
        //             li.add(x);
        //         }
        //         // System.out.println(x);
        //     }
        //     if(rec(li.get(0), target, 1, li)) ans+=target;
        // }

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        long ans =0;
        // Read input line by line
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            // Split the line into parts
            String[] parts = line.split(":");
            long target = Long.parseLong(parts[0].trim()); // First number is the target

            // Split the list part and parse the numbers into an ArrayList
            String[] numbers = parts[1].trim().split("\\s+");
            List<Long> numList = new ArrayList<>();
            for (String num : numbers) {
                numList.add(Long.parseLong(num));
            }
            if(rec(numList.get(0), target, 1, numList)) ans+=target;

        }
        System.out.println(ans);
    }

    static boolean rec(Long c,long t, int i, List<Long> li){
        if(i==li.size()){
            return c==t;
        }
        return rec(c+li.get(i), t, i+1, li) || rec(c*li.get(i), t, i+1, li)
            || rec(Long.parseLong(c.toString()+li.get(i)), t, i+1, li);
    }
}