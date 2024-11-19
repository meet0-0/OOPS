import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();

        String[] sentences = paragraph.split("[.!?]\s*");
        System.out.println("Total number of sentences: " + sentences.length);

        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].trim().split("\\s+");
            System.out.println("Number of words in sentence " + (i + 1) + ": " + words.length);
        }

        int totalCharacters = 0;
        int[] charCounts = new int[256]; 

        for (char ch : paragraph.toCharArray()) {
            if (ch != ' ') {
                totalCharacters++;
                ch = Character.toLowerCase(ch); 
                charCounts[ch]++;
            }
        }
        
        System.out.println("Total number of characters (excluding spaces): " + totalCharacters);
        System.out.println("Character occurrences:");
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                System.out.println((char) i + ": " + charCounts[i]);
            }
        }

        System.out.println("Enter a word to search:");
        String searchWord = scanner.next();
        
        String[] allWords = paragraph.split("\\s+");
        boolean found = false;
        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].equalsIgnoreCase(searchWord)) {
                System.out.println("The word \"" + searchWord + "\" is found at position: " + (i + 1));
                found = true;
            }
        }

        if (!found) {
            System.out.println("The word \"" + searchWord + "\" is not found in the paragraph.");
        }

        scanner.close();
    }
}
