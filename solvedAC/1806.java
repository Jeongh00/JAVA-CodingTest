package solvedAC;

import java.util.*;

public class 1806 {

    static int n,m;
    static int[] arr;
    static int answer;
    static int left, right, sum;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        answer = Integer.MAX_VALUE;
        left = 0;
        right = 0;
        sum = 0;

        while(left <= n && right <= n) {

            if(sum >= m) {
                answer = Math.min(answer, right-left);
                sum -= arr[left++];
            } else if(sum < m) {
                sum += arr[right++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE? 0: answer);
    }
}
