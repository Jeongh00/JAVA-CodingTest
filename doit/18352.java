package doit;

import java.util.*;

public class 18352 {

    static int n, m, k, x;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static List<Integer> answer;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        graph = new ArrayList[n+1];
        answer = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            graph[s].add(e);
        }

        visited = new int[n+1];
        for (int i=0; i<=n; i++) {
            visited[i] = -1;
        }

        BFS(x);

        for (int i=0; i<=n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int a : answer) {
                System.out.println(a);
            }
        }
    }

    private static void BFS(int x) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        visited[x]++;

        while(!q.isEmpty()) {

            int newx = q.poll();
            for (int i: graph[newx]) {
                if (visited[i] == -1) {
                    visited[i] = visited[newx] + 1;
                    q.add(i);
                }
            }
        }
    }
}
