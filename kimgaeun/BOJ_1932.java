package kimgaeun;
import java.util.*;

class BOJ_1932 {
    static int n;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        sum = new int[n][n];

        for(int i=0; i<n; i++){ //0,1
            for(int j=0; j<i+1; j++){ //1,2
                arr[i][j]=sc.nextInt();
            }
        }

        for(int j=0; j<n; j++){ //1,2
            sum[n-1][j]=arr[n-1][j]; //마지막 행 저장
        }
        // search(0,0);
        System.out.println(search(0,0));
        sc.close();
    }

    public static int search(int depth, int cur){
        if(depth==n-1){
            return sum[depth][cur];
        }

        if(sum[depth][cur]==0){
            sum[depth][cur]= Math.max(search(depth+1,cur),search(depth+1,cur+1))+arr[depth][cur];
        }
        
        return sum[depth][cur];
    }
    
}
