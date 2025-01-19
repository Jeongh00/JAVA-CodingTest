package solvedAC;

import java.util.*;
import java.io.*;

public class 14502 {

    static int n,m;
    static int maxSafeArea = Integer.MIN_VALUE;
    static int [][] rooms;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; i<m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createWall(0);
        System.out.println(maxSafeArea);
    }

    static void createWall(int wall) {

        if(wall == 3) {
            countSafeArea();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(rooms[i][j] == 0) {
                    rooms[i][j] = 1;
                    createWall(wall+1);
                    rooms[i][j] = 0;
                }
            }
        }
    }

    static void countSafeArea() {

        int[][] copyRooms = new int[n][m];

        for(int i=0; i<n; i++){
            copyRooms[i] = Arrays.copyOfRange(rooms[i], 0, m);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copyRooms[i][j] == 2) {
                    virus(copyRooms, i, j);
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copyRooms[i][j] == 0) {
                    cnt++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, cnt);
    }

    static void virus(int[][] copyRooms, int r, int c) {

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> positions = new LinkedList<>();

        positions.add(new int[]{r,c});

        while(!positions.isEmpty()) {

            int[] cur = positions.poll();

            for (int i = 0; i < 4; i++) {
    			int nr = cur[0] + dr[i];
    			int nc = cur[1] + dc[i];
    			
    			if (checkIndex(nr, nc) && copyRooms[nr][nc] == 0) {
    				copyRooms[nr][nc] = 3;
    				positions.add(new int[]{nr, nc});
    			}
    		}
        }
    }

    private static boolean checkIndex(int r, int c) {
    	return r >= 0 && r < n && c >= 0 && c < m;
    }
}
