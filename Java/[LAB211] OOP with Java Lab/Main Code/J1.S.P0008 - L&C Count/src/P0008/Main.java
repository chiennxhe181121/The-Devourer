package P0008;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String input = Validation.getString("Enter your content: ", "Invalid input! Please enter letters and spaces only.");

        // Maps to hold counts
        Map<String, Integer> wordCount = new HashMap<>();
        Map<Character, Integer> letterCount = new HashMap<>();

        // Split the input into words and count occurrences
        String[] words = input.split("\\s+"); // Split by whitespace
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            // Count letters in the word
            for (char ch : word.toCharArray()) {
                ch = Character.toLowerCase(ch); // Convert to lowercase for uniformity
                letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
            }
        }

        // Print word and letter occurrences
        System.out.println(wordCount);
        System.out.println(letterCount);
    }
}
