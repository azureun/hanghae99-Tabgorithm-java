package Code_2508;
import java.util.Scanner;
public class Day0812_물통옮기기 {
    public static int solution(int N, int[] waters){
        int count = 0;  // 작업 수 카운트

        // 모든 물통이 비워질 때까지 반복
        for(int i=0;i<N-1;i++){
            if(waters[i] > 0) {
                if(waters[i] <= waters[i+1]){
                    waters[i+1] -= waters[i];
                    waters[i] = 0;
                    count++;
                } else {
                    // 현재 물통이 더 많은 경우
                    waters[i] = 0;
                    count++;
                }
            }
        }
        if(waters[N-1] > 0) {
            waters[N-1] = 0;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int[] waters = new int[N];

        for(int i=0;i<N;i++){
            waters[i] = sc.nextInt();
        }
        // 결과 출력
        System.out.println(solution(N, waters));
        sc.close();
    }
}
