package todayCode_2504;

import java.io.*;
import java.util.*;

public class Day0417_가르침 {
    static int N, K;    // 단어, 알파벳 개수
    // 입력받은 단어들을 저장할 리스트
    static ArrayList<String> words = new ArrayList<>();

    static int solution(int N, int K, List<String> words) {
        // K가 5보다 작으면 'antic'도 못 배우므로 0 반환
        if (K < 5) return 0;    // antic도 못 배우면 읽을 수 있는 단어 없음

        // 반드시 배워야 하는 기본 글자들('antic') 집합
        Set<Character> basic = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));

        // 입력된 모든 단어에서 사용된 알파벳들의 집합 생성 (antic 제외)
        Set<Character> alpha = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                alpha.add(c);
            }
        }

        // 전체 알파벳에서 기본 글자들('antic')을 제외
        alpha.removeAll(basic); // 차집합 연산

        int maxReadable = 0;

        // 집합을 리스트로 변환하여 조합 생성 준비
        List<Character> alphaList = new ArrayList<>(alpha);
        // 선택해야 할 알파벳의 개수 계산 (전체 K개에서 'antic' 5개를 뺀 개수와 가능한 알파벳 수
        int selectCount = Math.min(alpha.size(), K-5);

        // 가능한 모든 조합을 확인하여 최대값 계산
        maxReadable = generateCombinations(alphaList, selectCount, basic, words);

        return maxReadable;
    }

    static int countReadableWords(Set<Character> basic, List<String> words) {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            //단어 전체의 각 문자에 대해
            for (char c : word.toCharArray()) {
                // 배운 글자에 없으면 읽을 수 없음
                if (!basic.contains(c)) {
                    readable = false;
                    break;
                }
            }
            if (readable) count++;
        }
        return count;
    }

    // 재귀적으로 알파벳 조합을 생성하고 각 조합으로 읽을 수 있는 단어 수를 확인
    static int generateCombinations(List<Character> alpha, int count, Set<Character> basic, List<String> words) {
        int maxCount = 0;
        // 모든 알파벳을 선택하면 읽을 수 있는 단어 수 반환
        if (count == 0) {
            return countReadableWords(basic, words);
        }
        // 남은 알파벳들 중에서 하나씩 선택하여 조합 생성
        for (int i = 0; i <= alpha.size() - count; i++) {
            // 새로운 글자 조합 생성 (기본 글자 + 선택된 알파벳)
            Set<Character> newLearned = new HashSet<>(Math.min(alpha.size(), K - 5));
            newLearned.add(alpha.get(i));

            // 다음 선택을 위해 남은 알파벳들로 새로운 리스트 생성
            List<Character> remaining = new ArrayList<>(alpha.subList(i + 1, alpha.size()));
            // 재귀적으로 다음 알파벳 선택
            maxCount = Math.max(maxCount, generateCombinations(remaining, count - 1, newLearned, words));
        }
        return maxCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 K 입력 받기
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N개의 단어 입력 받기
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        System.out.println(solution(N, K, words));
    }
}
