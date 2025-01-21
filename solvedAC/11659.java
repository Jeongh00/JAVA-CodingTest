package solvedAC;

import java.util.*;

public class 11659 {

    static int n,m;
    static int[] arr;
    static int s,e;
    static int sum;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int j=0; j<m; j++) {
            s = sc.nextInt();
            e = sc.nextInt();

            sum = 0;

            for(int k=s-1; k<e; k++) {

                sum += arr[k];
            }

            System.out.println(sum);
        }
    }
}
