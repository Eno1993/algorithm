package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MazeEscape {

    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };
    int[] start, lever, end;
    boolean[][][] visited;

    public class Node{
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int bfs(int x, int y, int[][] maps, int visit) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y][visit] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if(visit==0){
                if (node.x==lever[0]&&node.y==lever[1]){ return node.cost; }
            }else{
                if (node.x==end[0]&&node.y==end[1]){ return node.cost; }
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0<=nx&&nx<maps.length&&0<=ny&&ny<maps[0].length) {
                    if (maps[nx][ny]==1&&!visited[nx][ny][visit]) {
                        visited[nx][ny][visit] = true;
                        q.offer(new Node(nx, ny, node.cost+1));
                    }
                }
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        start = new int[2];
        lever = new int[2];
        end = new int[2];

        visited = new boolean[maps.length][maps[0].length()][2];
        int[][] sTol = new int[maps.length][maps[0].length()];
        int[][] lToe = new int[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                char c = maps[i].charAt(j);
                if(c=='X'){
                    sTol[i][j] = 0;
                    lToe[i][j] = 0;
                }else{
                    sTol[i][j] = 1;
                    lToe[i][j] = 1;
                    if(c=='S'){
                        start[0] = i;
                        start[1] = j;
                    }else if(c=='L'){
                        lever[0] = i;
                        lever[1] = j;
                    }else if(c=='E'){
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }

        int sTolCount = bfs(start[0], start[1], sTol, 0);
        if(sTolCount==-1){ return -1; }
        int lToeCount = bfs(lever[0], lever[1], lToe, 1);
        if(lToeCount==-1){ return -1; }
        return sTolCount + lToeCount -2;
    }
}
