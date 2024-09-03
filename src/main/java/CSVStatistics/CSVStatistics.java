package CSVStatistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CSVStatistics {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\234781\\eclipse-workspace\\exercise\\src\\main\\java\\CSVStatistics\\MOCK_DATA.csv"; // 假設CSV檔案名稱為data.csv

        // 打印CSV檔案內容
        printCSVContent(filePath);

        // 進行統計
        performStatistics(filePath);
    }

    private static void printCSVContent(String filePath) {
        System.out.println("CSV檔案內容:");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("無法讀取檔案: " + e.getMessage());
        }
    }

    private static void performStatistics(String filePath) {
        Map<String, Integer> genderCount = new HashMap<>();
        genderCount.put("male", 0);
        genderCount.put("female", 0);
        genderCount.put("other", 0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 跳過第一行（標題行）
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 6) {
                    String gender = fields[4].trim().toLowerCase(); // gender欄位
                    if (genderCount.containsKey(gender)) {
                        genderCount.put(gender, genderCount.get(gender) + 1);
                    } else {
                        genderCount.put("other", genderCount.get("other") + 1);
                    }
                }
            }

            // 印出統計結果
            System.out.println("統計結果:");
            for (Map.Entry<String, Integer> entry : genderCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("無法讀取檔案: " + e.getMessage());
        }
    }
}
