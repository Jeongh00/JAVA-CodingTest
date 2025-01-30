package lecture;

import java.util.*;

public class SlidingWindow {

    public static int solution(int n, int m, int[] arr) {

        int answer, sum = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        answer = sum;

        for(int j=k; j<n; j++) {
            sum += (arr[j] - arr[j-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {

            arr[i] = sc.nextInt();
        }

        System.out.println("");
    }
}
