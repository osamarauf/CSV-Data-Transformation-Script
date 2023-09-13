import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Set;

public class CSVToMapExample {
    public static void main(String[] args) throws IOException {
        String csvFilePath = "C:/Users/OsamaRauf/Downloads/2.csv";
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        String headers = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    headers = line;
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 5) {
                    String key = values[4];
                    String combinedValues = String.join(",", values[0], values[1], values[2], values[3], key, values[5], values[6], values[7]);
                    if (!hashMap.containsKey(key)) {
                        hashMap.put(key, combinedValues);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputCsvFilePath = "C:/Users/OsamaRauf/Downloads/1b.csv";
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFilePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        }
        ArrayList<String[]> newDataList = new ArrayList<>();
        Set<String> addedKeys = new HashSet<>();
        for (String[] row : data) {
            String keyToSearch = row[4];
            if (!addedKeys.contains(keyToSearch)) {
                String correspondingValues = hashMap.get(keyToSearch);
                if (correspondingValues != null) {
                    String[] valuesToAdd = correspondingValues.split(",");
                    valuesToAdd[4] = keyToSearch;
                    newDataList.add(valuesToAdd);
                    addedKeys.add(keyToSearch);
                }
            }
            newDataList.add(row);
        }
        String outputCsvFilePath = "C:/Users/OsamaRauf/Downloads/output.csv";
        try (FileWriter writer = new FileWriter(outputCsvFilePath)) {
            writer.write(headers + "\n");
            for (String[] row : newDataList) {
                writer.write(String.join(",", row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
