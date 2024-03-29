import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static Set<String> set = new HashSet<>();


    static void input() {
        N= sc.nextInt();
        for (int i=0; i<N; i++){
            set.add(sc.next());
        }
        List<String> list = new ArrayList<>();
        for (String s: set){
            list.add(s);
        }

        Collections.sort(list ,new Comparator<String>(){
            @Override
            public int compare(String me, String other){
                if (me.length() != other.length()){
                    return me.length() - other.length();
                }else{
                    return me.compareTo(other);
                }
            }
        });

        for (String s : list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
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