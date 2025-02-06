package solvedAC;

import java.util.*;

public class 9663 {

    static int n;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        DFS(0);
        System.out.println(count);
    }

    public static void DFS(int depth) {

        if (depth == n) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {

            arr[depth] = i;
            if(pos(depth)) {
                DFS(depth+1);
            }
        }
    }

    public static boolean pos(int col) {

        for (int i=0; i<col; i++) {

            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
