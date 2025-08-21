package conceptPrac;
import java.util.*;
// 향상된 for문 복습

// 기본 문법
/*
* for (데이터타입 변수명 : 배열 또는 컬렉션) {
*   // 실행할 코드
* }
* */
public class EnhancedFor {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // 기존 for
        /*
        for (int i=0; i<numbers.length; i++)
            System.out.print(numbers[i]);
        System.out.println();
        // 향상된 for문
        for (int number : numbers)
            System.out.print(number);
        System.out.println();
         */

        // String 배열 예제
        /*
        String[] names = {"Alice", "Bob", "Charlie"};
        for (String name : names)
            System.out.println("Hello, " + name);
        // char 배열 예제
        char[] chars = {'A', 'B', 'C'};
        for (char ch : chars)
            System.out.print(ch);
        System.out.println();
        */

        // 2차원 배열
        /*
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        for(int[] row: matrix) {
            for (int element : row)
                System.out.print(element + " ");
            System.out.println();
        } System.out.println();
        */

        // ArrayList
        /*
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        for (Integer num : list) {
            System.out.println(num);
        }*/

        // HashSet
        /*
        Set<String> set = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        for (String fruit : set) {
            System.out.println(fruit);
        }  System.out.println();
        */

        // HashMap의 키와 값 순회
        /*
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 95);
        map.put("Python", 100);
        // 키 순회
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }
        // 값 순회
        for (Integer value : map.values()){
            System.out.println("Value: " + value);
        }
        // 키-값 쌍 순회
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */
    }
}

// 알고리즘 활용
class Algorithm {
    // 배열 원소 합 구하기
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    // 최대값 찾기
    public static int findMax(int[] arr){
        int max = arr[0];
        for (int num : arr){
            if(num > max) {
                max = num;
            }
        }
        return max;
    }

    // 문자열 배열에서 특정 문자열 찾기
    public static boolean contains(String[] arr, String target){
        for(String str : arr){
            if (str.equals(target))
                return true;
        }
        return false;
    }

    // 리스트 - 홀/짝
    public static List<Integer> getEventNumbers(List<Integer> numbers){
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : numbers){
            if(num % 2 == 0)
                evenNumbers.add(num);
        }
        return evenNumbers;
    }
}