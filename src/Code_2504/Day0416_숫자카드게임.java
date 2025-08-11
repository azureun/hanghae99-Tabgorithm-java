package Code_2504;

import java.util.*;
import java.io.*;

public class Day0416_숫자카드게임 {
    public class CardSorting {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cards = new int[N];
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(minRemovalsToSort(N, cards));
        }

        public static int minRemovalsToSort(int n, int[] cards) {
            ArrayList<Integer> lis = new ArrayList<>();
            for (int card : cards) {
                int pos = Collections.binarySearch(lis, card);  // lis 위치 찾기 LIS (Longest Increasing Subsequence) : 최장 증가 부분 수열 배열
                // 이진 탐색 결과 양수이므로 (pos + 1), 음수일 경우, -(pos + 1)로 최적 삽입 위치 결정함. -> 최적 위치 계산 과정
                if (pos < 0) pos = (pos + 1);

                if (pos == lis.size()) {
                    lis.add(card);
                } else {
                    lis.set(pos, card);  // lts 배열에서 해당 위치를 현재 카드로 갱신. 현재까지 최적 성태 유지함.
                }
            }
            return n - lis.size();  // 최소 제거 카드 수 계산
        }

    }}
