import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter dc = new DuplicateCounter();
        String projectDir = System.getProperty("user.dir");
        String dataDir = projectDir + "/problem2.txt";
        String outDir = projectDir + "/unique_word_counts.txt";

        dc.count(dataDir);
        dc.write(outDir);
    }
}
