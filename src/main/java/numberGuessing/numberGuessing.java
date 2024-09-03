package numberGuessing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class numberGuessing {
    public static void main(String[] args) {
        // 生成符合新規則的四位數字秘密號碼
        String secretNumber = generateSecretNumber();
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.println("請輸入四位數字進行猜測（例如: 1234）：");
            String guess = scanner.nextLine();

            // 檢查猜測是否合法
            if (guess.length() != 4 || !isValidGuess(guess)) {
                System.out.println("請輸入有效的四位數字，每位數字在1到9之間且不包含重複。");
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

    // 生成符合新規則的四位數字秘密號碼（每位數字不重複）
    private static String generateSecretNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        // 取前四個數字
        return numbers.subList(0, 4).stream()
                      .map(String::valueOf)
                      .reduce("", String::concat);
    }

    // 檢查猜測是否合法（每位數字在1到9之間且不包含重複）
    private static boolean isValidGuess(String guess) {
        if (guess.length() != 4) {
            return false;
        }

        // 檢查每位數字是否在1到9之間且不重複
        boolean[] seen = new boolean[10]; // 用來標記1到9是否已經出現
        for (char c : guess.toCharArray()) {
            int digit = c - '0'; // 將字符轉換為數字
            if (digit < 1 || digit > 9 || seen[digit]) {
                return false; // 如果數字無效或重複，返回false
            }
            seen[digit] = true;
        }
        return true;
    }

    // 根據猜測和秘密號碼返回結果
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

