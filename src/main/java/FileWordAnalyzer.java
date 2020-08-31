import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    private final FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] words = getWords();
        Arrays.sort(words, Collator.getInstance());
        return Arrays.asList(words);
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String[] words = getWords();
        List<String> wordsContainingSubString = new ArrayList<>();
        Arrays.stream(words).filter(s -> s.contains(subString))
                .forEach(wordsContainingSubString::add);
        return wordsContainingSubString;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String[] words = getWords();
        List<String> palindromes = new ArrayList<>();
        Arrays.stream(words).filter(s -> isPalindrome(s.toCharArray()))
                .forEach(palindromes::add);
        return palindromes;
    }

    private String[] getWords() throws IOException {
        String content = fpr.read();
        return content.split(",");
    }

    private static boolean isPalindrome(char[] word) {
        int frontLetter = 0;
        int backLetter = word.length - 1;
        while (backLetter >= frontLetter) {
            if (word[frontLetter] != word[backLetter]) {
                return false;
            }
            ++frontLetter;
            --backLetter;
        }
        return true;
    }
}