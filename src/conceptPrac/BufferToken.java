package conceptPrac;
// BufferedReader, BufferedWriter, StringTokenizer 개념 복습
import java.io.BufferedReader;      // 엔터만을 경계값으로 인식, String 타입만 다룸, 8KB의 버퍼 사이즈 때문에 속도가 빠름
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;      // System.out.println();과 유사 > 버퍼를 거쳐 전달되므로 데이터 처리 효율성 높음
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BufferToken {
    public static void main(String[] args) throws IOException{  // BufferedReader는 IOException 던짐.
        //BufferedReader: 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // BufferedWriter: 대용량 출력, 파일 쓰기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringBuilder: 문자열 조작 후, 한 번에 출력
//        StringBuilder sb = new StringBuilder();
//        System.out.print(sb.toString());

        // 입력 예시
        System.out.print("이름 입력 : ");
        String name = br.readLine();
        System.out.print("나이 입력 : ");
        int age = Integer.parseInt(br.readLine());

        // StringTokenizer 예시
        System.out.print("2개의 숫자를 공백으로 구분해서 입력 : ");
        String inputLine = br.readLine();   // return : String
        // Read한 데이터는 Line 단위로만 나누어지므로 공백 단위 데이터를 가공하려면 따로 작업 필요.

        // 방법1 StringTokenizer: 더 빠름, 메모리 효율적
        // 방법1 split(): 정규식 사용 가능, 더 유연함

        // 방법 1. StringTokenizer에 nextToken() 함수 붙이면 readLine()을 통해 입력받은 값을 공백 단위로 구분 가능.
        StringTokenizer st = new StringTokenizer(inputLine);    // StringTokenizer 인자값에 입력 문자열 넣음
        int a = Integer.parseInt(st.nextToken());   // 첫번째 호출(띄어쓰기 기준)
        int b = Integer.parseInt(st.nextToken());   // 두번째 호출

        // 방법 2. String.split() 함수 활용하여 배열에 공백 단위로 끊어서 데이터를 넣고 사용하는 방식
        System.out.print("3개의 숫자를 공백으로 구분해서 입력 : ");
        String inputLine2 = br.readLine();
        String[] numbers = inputLine2.split(" ");   // 공백마다 데이터 끊어서 배열에 넣음

        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        int z = Integer.parseInt(numbers[2]);

        // BufferedWriter로 출력
        bw.write("<입력받은 정보>\n");
        bw.write("이름: " + name + "\n");
        bw.write("나이: " + age + "\n");
        bw.write("1st 계산: " + a + "+" + b + "=" + (a+b) + "\n");
        bw.write("2nd 계산: " + x + "+" + y + "+" + z + "=" + (x+y+z) + "\n");

        // 버퍼 비우기 & 스트림 닫기
        bw.flush(); // 남아있는 데이터를 모두 출력
        bw.close(); // 스트림을 닫음.
        br.close(); // garbage collection이 메모리 회수하나 성능상 적어주는 것이 좋음.
    }
}
