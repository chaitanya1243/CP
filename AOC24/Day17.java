import java.util.*;
import java.util.regex.*;
abstract class Instruction{
    boolean isCombo;
    Register reg;
    Pointer p;

    Instruction(Register reg, Pointer p, boolean isCombo){
        this.isCombo = isCombo;
        this.reg = reg;
        this.p = p;
    }

    abstract void perform();

    long operandValue(int x){
        if(!isCombo) return x;
        if(x==4)return reg.a;
        else if(x==5) return reg.b;
        else if(x==6) return reg.c;
        assert x!=7;
        return x;
    }
}


class Adv extends Instruction{

    Adv(Register reg, Pointer p){
        super(reg, p, true);
    }

    void perform(){
        int o = p.read();
        reg.a >>= operandValue(o);
        p.jump(2);
    }
}

class Bxl extends Instruction{

    Bxl(Register reg, Pointer p){
        super(reg, p, false);
    }

    void perform(){
        long v = operandValue(p.read());
        reg.b = reg.b ^ v;
        p.jump(2);
    }
}

class Bst extends Instruction{

    Bst(Register reg, Pointer p){
        super(reg, p, true);
    }

    void perform(){
        long v = operandValue(p.read());
        reg.b = v%8;
        p.jump(2);
    }
}

class Jnz extends Instruction{

    Jnz(Register reg, Pointer p){
        super(reg, p, false);
    }

    void perform(){
        long v = operandValue(p.read());
        if(reg.a==0){
            p.jump(2);
        }else{
            p.at=(int)v;
        }
    }
}

class Bxc extends Instruction{

    Bxc(Register reg, Pointer p){
        super(reg, p, false);
    }

    void perform(){
        long v = operandValue(p.read());
        reg.b = reg.b^reg.c;
        p.jump(2);
    }
}

class Out extends Instruction{

    Out(Register reg, Pointer p){
        super(reg, p, true);
    }

    void perform(){
        long v = operandValue(p.read());
        p.out((int)(v%8));
        p.jump(2);
    }
}

class Bdv extends Instruction{

    Bdv(Register reg, Pointer p){
        super(reg, p, true);
    }

    void perform(){
        int o = p.read();
        reg.b = reg.a / (1 << operandValue(o));
        p.jump(2);
    }
}
class Cdv extends Instruction{

    Cdv(Register reg, Pointer p){
        super(reg, p, true);
    }

    void perform(){
        int o = p.read();
        reg.c = reg.a / (1 << operandValue(o));
        p.jump(2);
    }
}

class Register{
    long a;
    long b;
    long c;
    Register(long a, long b, long c){
        this.a =a;
        this.b = b;
        this.c = c;
    }
}

class Pointer{
    String program;
    int at = 0;
    List<Integer> output = new ArrayList<>();

    Pointer(String s){
        program = s;
    }
    
    void jump(int n){
        at+=n;
    }
    int read(){
        return program.charAt(at)-'0';
    }

    boolean halt(){
        return at >= program.length();
    }

    void out(int x){
        output.add(x);
    }

    void reset(){
        at =0;
        output = new ArrayList<>();
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        var m1 =Pattern.compile("Register A: (\\d+)").matcher(sc.nextLine());
        
        var m2 =Pattern.compile("Register B: (\\d+)").matcher(sc.nextLine());
        var m3 =Pattern.compile("Register C: (\\d+)").matcher(sc.nextLine());
        m1.find();
        m2.find();
        m3.find();
        sc.nextLine();
        Register reg = new Register(Integer.parseInt(m1.group(1)), Integer.parseInt(m2.group(1)), Integer.parseInt(m3.group(1)));
        
        var m = Pattern.compile("Program: ([0-9,]*)").matcher(sc.nextLine());
        m.find();
        Pointer p =  new Pointer(m.group(1)+",");
        var instructions = List.of(new Adv(reg, p), new Bxl(reg, p), new Bst(reg, p), new Jnz(reg, p), new Bxc(reg, p), new Out(reg, p), new Bdv(reg, p), new Cdv(reg, p));
        // for(int a=1; a<Integer.MAX_VALUE; a++){
        //     reg.a=a;
        //     reg.b=0;
        //     reg.c=0;
        //     p.at =0;
        //     p.o = new StringBuilder();

        // // System.out.println(p.o.toString());
        // if(p.o.toString().equals(p.program)){
        //     System.out.println(a);
        //     break;
        // }
        // if(a%10000==0) System.out.println(a);
        // // break;
        // }
        // for(int i=0; i<1024; i++){
                reg.a=164516454365621l;
                reg.b=0;
                reg.c=0;
                p.reset();
                while(!p.halt()){
                    int x = p.read();
                    p.jump(2);
                    instructions.get(x).perform();
                }
        System.out.println(p.output);
        // }

        List<Long> cands = new ArrayList<>();
        for(long i=0; i<1024l; i++){
        
            cands.add(i);
        }
        List<Integer> targets = new ArrayList<>();
        p.reset();
        while(!p.halt()){
            targets.add(p.read());
            p.jump(2);
        }
        // System.out.println(cands);
        // System.out.println(targets);
        long pw = 1024;
        for(int i=0; i<targets.size(); i++){
            List<Long> newCands = new ArrayList<>();
            for(long c: cands){
                reg.a=c;
                reg.b=0;
                reg.c=0;
                p.reset();
                while(!p.halt()){
                    int x = p.read();
                    p.jump(2);
                    instructions.get(x).perform();
                }
                if(p.output.size() > i && targets.get(i) == p.output.get(i)){

                    // System.out.println(c+" "+p.output);
                    for(int j=0; j<9; j++){

                        newCands.add(c+pw*j);
                    }
                }
            }
            pw <<= 3;
            cands = newCands;
            Collections.sort(cands);
            System.out.println(cands.size()+" "+cands.get(0));
        }

        // System.out.println();
        // System.out.println(reg.a+" "+reg.b+" "+reg.c);

    }
}