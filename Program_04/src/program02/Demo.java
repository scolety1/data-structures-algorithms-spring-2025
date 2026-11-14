package program02;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpellChecker.loadDictionary();
        while (true) {
            System.out.print("\nEnter a Sentence:\n");
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            SpellChecker.processSentence(input);
        }
        scanner.close();
    }
}
