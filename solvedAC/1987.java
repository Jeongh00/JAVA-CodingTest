package solvedAC;

import java.util.*;

public class 1987 {

    static int r, c, answer=0;
    static char[][] graph;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static HashSet<Character> alphabet;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        graph = new char[r][c];

        for(int i=0; i<r; i++) {

            String line = sc.next();

            for(int j=0; j<c; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        alphabet = new HashSet<>();
        back(0,0,1);
        System.out.println(answer);
    }

    public static void back(int x, int y, int count) {

        answer = Math.max(answer, count);
        alphabet.add(graph[x][y]);

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!alphabet.contains(graph[nx][ny])) {
                    back(nx, ny, count + 1);
                }
            }
        }
        alphabet.remove(graph[x][y]);
    }
}
