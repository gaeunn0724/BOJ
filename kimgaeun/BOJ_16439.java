package kimgaeun;
import java.util.*;

class BOJ_16439 {
    static int N,M;
    static int arr[][];
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int x = sc.nextInt();
                arr[i][j]=x;
            }
        }

        //1. 치킨 먼저 고르고
        //2. 선호도 합하기
        int []chicken = new int[3];
        boolean []visited = new boolean[M];
        search(0, visited, chicken);
        System.out.println(answer);
    }

    static void search(int depth, boolean[]visited, int[] chicken){
        if(depth == 3){
            int sum=0;
            for(int j=0; j<N; j++){ //인원수 
                int max=0;
                for(int i=0; i<chicken.length; i++){
                    max = Math.max(max, arr[j][chicken[i]]); //사람마다 선호도 max구하고                 
                }
                sum+=max; //sum더하기
            }
            answer=Math.max(sum , answer);            
            return;
        }

        for(int i=0; i<M; i++){
            if(!visited[i]){
                visited[i] = true;
                chicken[depth]=i;
                search(depth+1, visited, chicken);
                visited[i]=false;
            }
        }
    }
}
