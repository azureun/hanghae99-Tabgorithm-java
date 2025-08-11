package Code_2504;

import java.util.Scanner;

public class Day0415_곰이사는동굴 {

    public static long maxBearsInCave(int n, long[] caves) {
        long totalBears = 0;
        boolean[] occupied = new boolean[n];  // 각 주요 방에 곰이 있는지 여부
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;

            if (!occupied[prev]) {
                if (caves[i] > 0) {
                    caves[i]--;
                    totalBears++;
                } else {
                    occupied[i] = true;
                    totalBears++;
                }
            }
        }

        return totalBears;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력 받기
        int n = sc.nextInt();              // 주요 방의 개수
        long[] caves = new long[n];        // 각 방에 연결된 작은 동굴 수

        for (int i = 0; i < n; i++) {
            caves[i] = sc.nextLong();
        }

        long result = maxBearsInCave(n, caves);
        System.out.println("최대 곰 수 : " + result);
    }
}
