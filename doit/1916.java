package doit;

import java.util.*;

public class 1916 {

    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n+1];
        dist = new int[n+1];
        visit = new boolean[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i=0; i<m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            list[start].add(new Node(end, weight));
        }

        int sIndex = sc.nextInt();
        int eIndex = sc.nextInt();
        System.out.println(dijkstra(sIndex, eIndex));
    }

    public static int dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;

            if(!visit[now]) {

                visit[now] = true;
                for(Node n : list[now]) {

                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value) {
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }

        return dist[end];
    }
}

class Node implements Comparable<Node> {

    int targetNode;
    int value;

    Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}
