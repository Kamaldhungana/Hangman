import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of words for the game
        String[] wordList = {"programming", "java", "hangman", "developer", "computer"};
        // Randomly select a word from the list
        String word = wordList[(int) (Math.random() * wordList.length)];
        
        // Create a char array to keep track of guessed letters
        char[] wordToGuess = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordToGuess[i] = '_';
        }
        
        int attemptsLeft = 6; // Number of allowed attempts
        boolean wordGuessed = false;
        String guessedLetters = ""; // String to track the letters that have already been guessed

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");
        
        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("\nCurrent word: " + new String(wordToGuess));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            
            char guess = sc.next().toLowerCase().charAt(0); // Get the guessed letter
            
            // Check if the letter was already guessed
            if (guessedLetters.indexOf(guess) != -1) {
                System.out.println("You already guessed that letter.");
                continue;
            }
            
            guessedLetters = guessedLetters + guess; // Add guessed letter to the guessedLetters string
            
            boolean correctGuess = false;

            // Check if the guess is in the word
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    wordToGuess[i] = guess; // Replace the underscore with the guessed letter
                    correctGuess = true;
                }
            }

            // If the guess was wrong, decrement attemptsLeft
            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Incorrect guess!");
            }

            // Check if the word is fully guessed
            wordGuessed = true;
            for (int i = 0; i < wordToGuess.length; i++) {
                if (wordToGuess[i] == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        // Game end conditions
        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + word);
        } else {
            System.out.println("\nGame over! The word was: " + word);
        }

        sc.close();
    }
}
