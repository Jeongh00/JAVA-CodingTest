package solvedAC;

import java.util.*;
import java.io.*;

public class 15686 {

    static int N,M;
    static int[][] city;
    static boolean[] check;
    static int answer;

    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();

    static class Point {

        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");

        N = Integer.parseInt(str1[0]); // 도시 N*N
        M = Integer.parseInt(str1[1]); // 치킨집 M 개

        city = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] str2 = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(str2[j]);

                if(city[i][j] == 2) {
                    chicken.add(new Point(i, j));
                } else if(city[i][j] == 1) {
                    house.add(new Point(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        check = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int start, int depth) {

        if(depth == M) {
            int sum = 0;

            for(int i=0; i<house.size(); i++) {

                int min = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++) {

                    if(check[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(min, distance);
                    }
                }

                sum += min;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for(int i=start; i<chicken.size(); i++) {

            check[i] = true; 
            dfs(i+1, depth+1);
            check[i] = false;
        }
    }
}
