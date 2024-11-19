import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParagraphAnalysis {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter a string (max 80 characters, ending with a full stop):");
            String input = scanner.nextLine().trim();
            
            if (input.length() > 80 || !input.endsWith(".")) {
                System.out.println("Invalid input. Ensure the string is up to 80 characters and ends with a full stop.");
                return;
            }
    
            String[] words = input.substring(0, input.length() - 1).trim().split("\\s+");
    
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String w1, String w2) {
                    if (w1.length() != w2.length()) {
                        return w2.length() - w1.length(); 
                    }
                    return w1.compareToIgnoreCase(w2); 
                }
            });
    
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
    
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(word).append(" ");
            }
            result.setCharAt(result.length() - 1, '.'); 
    
            System.out.println("Sorted sentence: " + result);
    
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(input.toString()); //string in user input order
                writer.write(result.toString()); //string in descending order
                System.out.println("The sorted sentence has been written to output.txt.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
    
            scanner.close();
        }
}