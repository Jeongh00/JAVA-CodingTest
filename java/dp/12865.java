package java.dp;

import java.util.*;
import java.io.*;

public class 12865 {
    static int N;
    static int limit;
    static int[] weight;
    static int[] value;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        weight = new int[N+1];
        value = new int[N+1];

        for( int i = 1; i < N+1 ; i++ ){
            st = new StringTokenizer(bf.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            weight[i] = W;
            value[i] = V;
        }

        dp = new int[N+1][limit+1];

        for( int i = 1; i < N + 1 ; i++ ){
            for( int j = 1; j < limit + 1; j++ ){
                dp[i][j] = dp[i-1][j];

                if( weight[i] <= j ) {
                    dp[i][j] = Math.max( dp[i][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][limit]);
    }

}