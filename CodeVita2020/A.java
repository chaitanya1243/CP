import java.util.*;

class A
{
    Scanner in = new Scanner(System.in);
    class SM
    {
        boolean shirt, shoe;
        int shirtCost, shoeCost;
        int shirtQty, shoeQty;
        int add(String name, int q){
            if(name.equals("SHIRT")){
                if(shirt) return -1;
                shirt = true;
                shirtQty = q;
            }
            else{
                if(shoe) return -1;
                shoe = true;
                shoeQty = q;
            }
            return q;
        }
        int remove(String name){
            if(name.equals("SHIRT")){
                if(!shirt) return -1;
                shirt = false;
                shirtQty = 0;
            }
            else{
                if(!shoe) return -1;
                shoe = false;
                shoeQty = 0;
            }
            return 1;
        }
        int incr(String name, int q){
            if(name.equals("SHIRT")){
                if(!shirt) return -1;
                shirtQty += q;
            }
            else{
                if(!shoe) return -1;
                shoeQty += q;
            }
            return q;
        }
        int dcr(String name, int q){
            if(name.equals("SHIRT")){
                if(!shirt || shirtQty<q) return -1;
                shirtQty -= q;
            }
            else{
                if(!shoe || shoeQty<q) return -1;
                shoeQty -= q;
            }
            return q;
        }
        double setCost(String name, int v){
            if(name.equals("SHIRT")){
                shirtCost = v;
            }
            else{
                shoeCost = v;
            }
            return v;
        }
        int getQty(String name){
            if(name.equals("SHIRT")){
                return shirtQty;
            }
            else{
                return shoeQty;
            }
        }
    }
    class S
    {
        boolean shirt, shoe;
        int shirtQty, shoeQty;
        SM ob;
        int add(String name, int q){
            if(ob.dcr(name, q)==-1) return -1;
            if(name.equals("SHIRT")){
                if(shirt) return -1;
                shirt = true;
                shirtQty = q;
            }
            else{
                if(shoe) return -1;
                shoe = true;
                shoeQty = q;
            }
            return q;
        }
        int remove(String name){
            
            if(name.equals("SHIRT")){
                if(!shirt) return -1;
                shirt = false;
                shirtQty = 0;
            }
            else{
                if(!shoe) return -1;
                shoe = false;
                shoeQty = 0;
            }
            return 1;
        }
        int incr(String name, int q){
            if(name.equals("SHIRT")){
                shirt = false;
                shirtQty = 0;
            }
            else{
                shoe = true;
                shoeQty = 0;
            }
        }
        int dcr(String name, int q){
            if(name.equals("SHIRT")){
                shirt = false;
                shirtQty = 0;
            }
            else{
                shoe = true;
                shoeQty = 0;
            }
        }
        int getAmount(){
            if(name.equals("SHIRT")){
                shirt = false;
                shirtQty = 0;
            }
            else{
                shoe = true;
                shoeQty = 0;
            }
        }
    }
    void run(){
        Obj sm = new Obj();
        Obj s = new Obj();

    }
    public static void main(String args[]){
        new A().run();
    }
}