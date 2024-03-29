import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7 4
0000
1110
1100
1101
0000
0111
0000
 */

public class Main {
    static class P{
        int x, y, time;
        int isBreak;

        public P(int x, int y, int time, int isBreak) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isBreak = isBreak;
        }
    }

    static int [] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static int N, M;
    static int [][] map;
    static int [][] visit; //방문여부
    static int ans;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
//        visit = new boolean[2][N+1][M+1];
        visit = new int[N+1][M+1];

        for (int i=1; i<=N; i++){
            String temp = br.readLine();
            for (int j = 1; j <= M ; j++ ){
                map[i][j] = temp.charAt(j-1)-'0';
            }
        }

        for(int i=1; i<= N; i++){
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        ans = -1;
        bfs(1,1);
        System.out.println(ans);

//        System.out.println("----------");
//        for(int i=1; i <= N; i++) System.out.println(Arrays.toString(time[i]));
//        for(int i=1; i <= N; i++) System.out.println(Arrays.toString(visit[i]));

    }
    static void bfs(int sx, int sy)
    {
        ArrayDeque<P> q = new ArrayDeque<>();
        q.addLast(new P(sx, sy, 1, 0));
        visit[sx][sy] = 0;

        while(!q.isEmpty()){
            P out = q.pollFirst();
            if(out.x == N && out.y == M){
                ans = out.time;
                break;
            }
            for(int d = 0; d < 4; d++){
                int nx = out.x + dx[d];
                int ny = out.y + dy[d];
                if( !inArea(nx, ny) || out.isBreak >= visit[nx][ny]) continue;

                if(map[nx][ny] == 1){
                    if(out.isBreak == 0){
                        visit[nx][ny] = 1;
                        q.addLast(new P(nx, ny, out.time+1, 1));
                    }

                }else{ //땅이라면
                    if(out.isBreak == 0){ //현재는 벽을 안 깬 상태에서, 벽을 깼던 점이 지나간 곳(visit == 1) 재방문 가능
                        visit[nx][ny] = out.isBreak;
                        q.addLast(new P(nx, ny, out.time+1, 0));
                    }else{ //벽을 깼다면
                        //방문하지 않았던 곳만 가능
                        visit[nx][ny] = out.isBreak;
                        q.addLast(new P(nx, ny, out.time+1, 1));
                    }

                }
            }//for
        }//while

    }
    static boolean inArea(int x, int y){
        return x > 0 && y > 0 && x <= N && y <= M;
    }

}
