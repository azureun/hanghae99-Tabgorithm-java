package Code_2508;
import java.io.*;
import java.util.Stack;

public class Day0823_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initialString = br.readLine();       // 초기 문자열 입력 받기
        int n = Integer.parseInt(br.readLine());    // 명령어 개수 입력 받기

        Stack<Character> leftStack = new Stack<>();     // 왼쪽 커서
        Stack<Character> rightStack = new Stack<>();    // 오른쪽 커서

        for (char c : initialString.toCharArray()) {
            leftStack.push(c);
        }

        for (int i = 0; i<n; i++){  // 명령어 개수 만큼 반복
            String command = br.readLine();

            if (command.equals("L")) {
                if(!leftStack.isEmpty()){       // L커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    rightStack.push(leftStack.pop());
                }
            } else if (command.equals("D")) {
                if(!rightStack.isEmpty()) {     // D 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    leftStack.push(rightStack.pop());
                }
            } else if (command.equals("B")) {
                if (!leftStack.isEmpty()) {     // (커서가 문장의 맨 앞이면 무시됨)
                    leftStack.pop();            // B 커서 왼쪽에 있는 문자를 삭제함
                }
            }
            else if (command.startsWith("P")) {
            //else if (command.startsWith("P")) { // P $ $라는 문자를 커서 왼쪽에 추가함
                char c = command.split(" ")[1].charAt(0);
                //char c = command.charAt(2); // P $에서 $는 인덱스 2
                leftStack.push(c);
            }
        }
        for (char c : leftStack) {
            bw.write(c);
        }
        while(!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
