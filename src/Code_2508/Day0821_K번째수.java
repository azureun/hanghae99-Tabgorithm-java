package Code_2508;
import java.util.Scanner;

class KthNum{
    private int n;
    private long k;
    public KthNum(int n, long k){
        this.n = n;
        this.k = k;
    }
    public long findKthNumber() {
        long left = 1, right = n * (long)n;
        long answer = 0;

        while (left <= right) { //중간값보다 작거나 같은 수의 개수
            long mid = (left + right) / 2;
            long count = 0L;    // 각 행에서 중간값 보다 작거나 같은 수의 개수를 누적할 변수 초기화. long 타입 명시

            for(int i=1;i<=n;i++){
                // 각 행에서 mid보다 작거나 같은 수의 개수
                count+= Math.min(mid/(long)i, n);   // mid를 i로 나눈 몫 & n중 가장 작은 값
            }
            if (count < k) {    // 현재의 mid 값이 k번째 수보다 작을 경우
                left = mid + 1; // 탐색 범위를 오른쪽으로 이동
            } else {
                answer = mid;
                right = mid - 1;    // 탐색 범위를 왼쪽으로 이동
            }
        }
        return answer;
    }
}

public class Day0821_K번째수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();
        KthNum kthNum = new KthNum(N, K);
        System.out.println(kthNum.findKthNumber());
        sc.close();
    }
}

/*
class KthNum {
    public static long findKthNumber(int n, long k) {
        long left = 1, right = n * (long)n;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0L;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / (long)i, n);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
public class Day0821_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();

        // 객체 생성 없이 바로 호출
        System.out.println(KthNum.findKthNumber(N, K));

        sc.close();
    }

*/