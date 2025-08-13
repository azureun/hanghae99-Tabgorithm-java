package Code_2508;
import java.util.Scanner;

public class Day0813_레고조립시간 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sizes = new int[N];

        for(int i=0;i<N;i++){
            sizes[i] = sc.nextInt();
        }
        System.out.println(legoAssemblyTime(N, sizes));
    }

    public static int legoAssemblyTime(int n, int[] sizes) {
        int totalTime = 0;
        boolean swapped;

        do {
            swapped = false;
            for(int i=0;i<n-1;i++){
                if(sizes[i] > sizes[i+1]){  // 레고 크기 비교 (오름차순 정렬)
                    totalTime += Math.abs(sizes[i] - sizes[i+1]);   // 교환 시간 계산

                    int temp = sizes[i];
                    sizes[i] = sizes[i+1];
                    sizes[i+1] = temp;
                    swapped = true;
                }
            }
            n--;    // 정렬 범위 줄이기
        } while (swapped);

        return totalTime;
    }
}
