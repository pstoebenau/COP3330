import java.io.*;
import java.util.*;

public class DuplicateCounter {
    HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException{
        File file = new File(dataFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String word = scanner.next();
            addCountToMap(word);
        }

        scanner.close();
    }

    public void write(String outFile) throws IOException {
        File file = new File(outFile);
        FileWriter fileWriter = new FileWriter(file);
        String output;
        StringBuilder outputBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            outputBuilder.append(key).append(": ").append(val).append(" occurrences\n");
        }

        output = outputBuilder.toString();

        fileWriter.write(output);
        fileWriter.close();
    }

    private void addCountToMap(String word) {
        if (!wordCounter.containsKey(word)) {
            wordCounter.put(word, 1);
            return;
        }

        int newCount = wordCounter.get(word) + 1;
        wordCounter.put(word, newCount);
    }
}
