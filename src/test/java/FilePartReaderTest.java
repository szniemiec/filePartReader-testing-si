import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilePartReaderTest {

    private final FilePartReader fpr = new FilePartReader();

    public FilePartReaderTest() {
        int fromLine = 1;
        int toLine = 5;
        String testFilePath = "src\\main\\resources\\testFile.txt";
        fpr.setup(testFilePath, fromLine, toLine);
    }

    @Test
    void isFileRead() {
        String expected = "basia,ania,wujek,mariusz,andrzejek,kajak,";

        String output = fpr.read();

        Assertions.assertEquals(expected, output);
    }
}