import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateRemover dr = new DuplicateRemover();
        String projectDir = System.getProperty("user.dir");
        String dataDir = projectDir + "/problem1.txt";
        String outDir = projectDir + "/unique_words.txt";

        dr.remove(dataDir);
        dr.write(outDir);
    }
}
