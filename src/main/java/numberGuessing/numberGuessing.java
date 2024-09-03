package numberGuessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class numberGuessing {
    public static void main(String[] args) {
        // 生成隨機四位數字
        String secretNumber = generateRandomNumber();
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.println("請輸入四位數字進行猜測（例如: 1234）:");
            String guess = scanner.nextLine();

            if (guess.length() != 4 || !guess.matches("\\d+")) {
                System.out.println("請輸入有效的四位數字！");
                continue;
            }

            attempts++;
            String result = getResult(guess, secretNumber);
            System.out.println("結果: " + result);

            if (result.equals("4A0B")) {
                System.out.println("恭喜！你猜對了，總共嘗試了 " + attempts + " 次！");
                break;
            }
        }

        scanner.close();
    }

    // 生成不重複的四位數字
    private static String generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 4).stream()
                      .map(String::valueOf)
                      .reduce("", String::concat);
    }

    // 根據猜測和秘密數字返回結果
    private static String getResult(String guess, String secretNumber) {
        int A = 0, B = 0;

        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                A++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                B++;
            }
        }

        return A + "A" + B + "B";
    }
}
