package lecture;

import java.util.*;

public class greedy {

    public static int solution(ArrayList<Body> arr, int n) {

        int cnt = 0;
        Collections.sort(arr);

        int max = Integer.MIN_VALUE;
        for(Body ob : arr) {
            if(ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            arr.add(new Body(h, w));
        }

        System.out.println(solution(arr, n));
    }
}

class Body implements Comparable<Body> {

    public int h, w;
    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h; // 내림차순
    }
}
