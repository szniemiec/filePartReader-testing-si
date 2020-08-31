import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("src\\main\\resources\\testFile.txt", 1, 5);
        String fileContent = fpr.read();
        System.out.println(fileContent);

        System.out.println();
        System.out.println("dupa");
        System.out.println();

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

        for (String s : fwa.getWordsOrderedAlphabetically()) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("dupaa");
        System.out.println();

        for (String s : fwa.getWordsContainingSubstring("ia")) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("dupaaa");
        System.out.println();

        for (String s : fwa.getStringsWhichPalindromes()) {
            System.out.println(s);
        }
    }
}
