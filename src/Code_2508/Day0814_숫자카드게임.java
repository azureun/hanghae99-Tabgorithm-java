package Code_2508;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Day0814_숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cards = new int[N];
        for(int i=0;i<N;i++){
            cards[i] = Integer.parseInt(st.nextToken());    // 띄어쓰기 기준으로 다음 수 입력 받기
        }
        System.out.println(minRemovalsToSort(N, cards));
    }
    public static int minRemovalsToSort(int n, int[] cards){
        ArrayList<Integer> lis = new ArrayList<>();
        for(int card : cards) {
            int pos = Collections.binarySearch(lis, card);   // lis 위치 찾기 LIS (Longest Increasing Subsequence)
            if (pos < 0)    // 현재 위치가 0보다 작을 때
                pos = (pos + 1);    // 다음 배열 위치 이동
            if (pos == lis.size()) {
                lis.add(card);
            } else {
                lis.set(pos, card);
            }
        }
        return n - lis.size();   //최소 제거 카드 수 계산 후, 리턴
    }
}
