import java.util.*;

class B
{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), radius = 6371;
    double lat[] = new double[n];
    double lng[] = new double[n];
    int height[] = new int[n];
    double jlat, jlong;
    void solve(){
        for(int i=0; i<n; i++)
        lat[i] = in.nextDouble();
        for(int i=0; i<n; i++)
        lng[i] = in.nextDouble();
        for(int i=0; i<n; i++)
        height[i] = in.nextInt();
        jlat = in.nextDouble();
        jlong = in.nextDouble();
        int ans= 0;
        for(int i=0; i<n; i++){
            double val1 = dist(lat[i], lng[i]);
            double val2 = Math.pow(2*height[i]*radius,0.5);
            if(Double.compare(val1,val2)<=0)
            ans++;
        }
        System.out.print(ans);
    }
    double dist(double x1, double y1) 
    {
        double d1 = Math.toRadians(x1 - jlat); 
        double d2 = Math.toRadians(y1 - jlong);
        x1 = Math.toRadians(x1); 
        double x3 = Math.toRadians(jlat); 
        double ab = Math.pow(Math.sin(d1 / 2), 2) + Math.pow(Math.sin(d2 / 2), 2) *  
                   Math.cos(x1) *  Math.cos(x3);
        return radius *2 * Math.asin(Math.sqrt(ab));
    } 
    public static void main(String args[]){
        new B().solve();
    }
}