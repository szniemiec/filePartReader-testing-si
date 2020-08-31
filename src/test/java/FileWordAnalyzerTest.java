import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FileWordAnalyzerTest {

    private final FileWordAnalyzer fwr;

    public FileWordAnalyzerTest() {
        int fromLine = 1;
        int toLine = 5;
        String testFilePath = "src\\main\\resources\\testFile.txt";
        FilePartReader fpr = new FilePartReader();
        fpr.setup(testFilePath, fromLine, toLine);
        fwr = new FileWordAnalyzer(fpr);
    }

    @Test
    void areWordsAlphabeticallyOrdered() {
        List<String> expected = Arrays.asList("andrzejek", "ania", "basia", "kajak", "mariusz", "wujek");
        List<String> output = null;

        try {
            output = fwr.getWordsOrderedAlphabetically();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        Assertions.assertEquals(expected, output);
    }

    @Test
    void getWordsContainingSubstring() {
        List<String> expected = Arrays.asList("basia", "ania");
        List<String> output = null;

        try {
            output = fwr.getWordsContainingSubstring("ia");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        Assertions.assertEquals(expected, output);
    }

    @Test
    void getStringsWhichPalindromes() {
        List<String> expected = Collections.singletonList("kajak");
        List<String> output = null;

        try {
            output = fwr.getStringsWhichPalindromes();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        Assertions.assertEquals(expected, output);
    }
}