import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilePartReader {

    String filePath;
    int fromLine;
    int toLine;

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.flatMap(line -> Arrays.stream(line.split(" +")))
                    .forEach(word -> sb.append(word).append(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}