package jarekjal.codewars.kyu6;

public class Epidem {
    public static int epidemic(int tm, int n, int s0, int i0, double b, double a) {

        double sk = s0;
        double ik = i0;
        double rk = 0;
        double dt = ((double)tm) / n;
        double ikMax = 0;
        for (int k = 0; k < n; k++){
            double skNext = sk - dt * b * sk * ik;
            double ikNext = ik + dt * (b * sk * ik - a * ik);
            double rkNext = rk + dt * ik * a;
            if (ik > ikMax) ikMax = ik;
            sk = skNext;
            ik = ikNext;
            rk = rkNext;
            //System.out.println("k: " + k + " sk: " + sk + " ik: " + ik + " rk: " + rk);
        }
        return (int) ikMax;
    }
}
