package Code_2508;
import java.util.Scanner;

public class Day0822_히든넘버 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 입력할 문자열 개수
        sc.nextLine();
        String s = sc.nextLine();

        long totalSum = 0;
        long currentNumber = 0;

        for (char c : s.toCharArray()){     // 한 문자씩 반복하므로 문자열을 문자의 배열로 만듦.
            if (Character.isDigit(c))   // 현재 문자가 숫자인지 확인
                currentNumber = currentNumber * 10 + (c-'0');
                // 히든 숫자는 연속된 숫자로 2자리 이상인 경우
                // 기존 숫자에 10을 곱하고, 현재 1의 자리수 값을 (c-'0') 연산을 통해 구한다음 더해줌.
            else {
                totalSum += currentNumber;  // 숫자가 아닌 경우, 저장된 현재 숫자 더해서 저장함
                currentNumber = 0;  // 더해지는 현재 숫자 초기화
            }
        }
        totalSum += currentNumber;  // 최종으로 totalSum 구함

        System.out.println(totalSum);
        sc.close();
    }
}

