import java.util.*;
import java.io.*;

public class DuplicateRemover {
    public ArrayList<String> uniqueWords = new ArrayList();

    public void remove(String dataFile) throws IOException {
        File file = new File(dataFile);
        Scanner scanner = new Scanner(file);
        String fileContents = scanner.nextLine();
        FileWriter fileWriter;

        // Populate uniqueWords with all unique words
        getUniqueStrings(file);

        // Copy file into string
        while (scanner.hasNextLine())
            fileContents += "\n" + scanner.nextLine();
        scanner.close();

        // Erase file and open for writing
        fileWriter = new FileWriter(file);

        for (int i = 0; i < uniqueWords.size(); i++)
            fileContents = fileContents.replaceFirst(uniqueWords.get(i), "#");

        for (int i = 0; i < uniqueWords.size(); i++)
            fileContents = fileContents.replaceAll(uniqueWords.get(i), "");

        for (int i = 0; i < uniqueWords.size(); i++)
            fileContents = fileContents.replaceFirst("#", uniqueWords.get(i));

        fileWriter.write(fileContents);
        fileWriter.close();
    }

    public void write(String outputFile) throws IOException {
        File fileOut = new File(outputFile);
        FileWriter fileWriter = new FileWriter(fileOut);

        for (int i = 0; i < uniqueWords.size(); i++) {
            String word = uniqueWords.get(i);
            fileWriter.write(word + "\n", 0, word.length()+1);
        }

        fileWriter.close();
    }

    private void getUniqueStrings(File file) throws IOException{
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String word = scanner.next();
            addUniqueStrings(word);
        }

        scanner.close();
    }

    private void addUniqueStrings(String str) {
        for (int i = 0; i < uniqueWords.size(); i++)
            if (str.compareTo(uniqueWords.get(i)) == 0)
                return;

        uniqueWords.add(str);
    }
}
