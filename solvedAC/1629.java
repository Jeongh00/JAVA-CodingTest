package solvedAC;

import java.util.*;

public class 1629 {
    
    static int a, b, c;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(pow(a,b,c) % c);
    }

    static long pow(int a, int b, int c) {

        if(b == 0) {
            return 1;
        } else if(b == 1) {
            return a;
        } else if(b%2 == 0) {
            long n = pow(a, b/2, c) % c;
            return(n*n) % c;
        } else {
            long n = pow(a, b/2, c) % c;
            return(((n*n) & c) * a) % c;
        }
    }
}
