import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int [] A, P;
    static int [][] B;
    static boolean [] visit ;
    static void input() {
        N= sc.nextInt();
        A = new int[N];
        B = new int[N][2];
        P = new int[N];
        visit = new boolean[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
            B[i] = new int[]{A[i],i};
        }
        Arrays.sort(B, new Comparator<int[]>(){
            @Override
            public int compare(int[] me, int[] other){
                //[0] 오름차순, 같다면 [1] 오름차순
                if (me[0] != other[0]) return me[0] - other[0];
                else return me[1] - other[1];
            }
        });
//        System.out.println(Arrays.deepToString(B));
        //B를 순회하며
        for (int b=0; b<B.length; b++){
            P[B[b][1]]= b;
        }
        for (int i: P){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
        //P[B[1]] = b인덱스;

    }
    static void pro() {

    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));

            }
            String next(){
                while (st == null || !st.hasMoreTokens()){  //현재 남아 있는 토큰이 없다면 새로 받아온다.
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt(){
                return Integer.parseInt(next());
            }
            long nextLong(){return Long.parseLong(next()); }

            double nextDouble(){return Double.parseDouble(next());}

            String nextLine(){
                String str ="";
                try {
                    str = br.readLine();

                }catch (IOException e){
                    e.printStackTrace();
                }
                return str;
            }
            void close() {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
}