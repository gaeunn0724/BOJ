package kimgaeun;
import java.util.*;

class BOJ_16922 {
    static int count=0;
    static int N;
    static int[] arr = {1,5,10,50};
    static boolean []visited = new boolean[50*20+1];
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
                
        dfs(0,0,0);
        System.out.println(count);
    }    

    public static void dfs(int len, int sum, int start){
        if(len==N){
            if(!visited[sum]){
                visited[sum]=true;
                count++;
            }
            return;
        }

        for(int i=start; i<4; i++){
           dfs(len+1, sum+arr[i], i);
        }
    }
}
