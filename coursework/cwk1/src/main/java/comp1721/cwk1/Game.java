package comp1721.cwk1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Game {

  private int gameNumber;
  private String target; 
  private List<String> guesses = new ArrayList<>();

  // TODO: Implement constructor with String parameter
  public Game(String filename) throws IOException{
    // Gets the current date and saves it
    LocalDate today = LocalDate.now();
    // Gets the day of the first wordle and saves it 
    LocalDate firstWordleDay = LocalDate.of(2021,Month.JUNE,19);

    // Finds the difference between the current date and the first wordle day to figure out the current game number
    long daysDifference = ChronoUnit.DAYS.between(firstWordleDay, today);
    gameNumber = (int) daysDifference;

    // Finds the target word in the file and saves it
    WordList words = new WordList(filename);
    target = words.getWord(gameNumber);

  }


  // TODO: Implement constructor with int and String parameters
  public Game(int num, String filename) throws IOException{
    // Assign the custom gameNumber
    gameNumber = num;

    // Find the current word based on the custom gameNumber
    WordList words = new WordList(filename);
    target = words.getWord(num);

  }


  // TODO: Implement play() method
  public void play(){
      // Print the current game number at the top of the screen
      System.out.printf("Wordle %d %n%n", gameNumber);
      // Loops through every possible guess
      for(int i = 1; i < 7; i++) {
        // Create a new guess object for each guess
        Guess guess = new Guess(i);
        // Print a message to the player to make a guess based on the game number
        System.out.printf("Enter guess (%d/6): ", guess.getGuessNumber());
        // Read the player input
        guess.readFromPlayer();
        // Validate the guess of the chosen word 
        Guess validateGuess = new Guess(i, guess.getChosenWord());
        // Print the guess of the player compared to target
        System.out.println(guess.compareWith(target));
        
        // Adds all the players gueses to an arrayList
        guesses.add(guess.compareWith(target));

        if (guess.matches(target)){ 
          // If the player guesses it one go
          if (i == 1){
            System.out.print("Superb - Got it in one!\n");
            break;
          } else if ((i > 1) && (i < 6)){ // If the player guesses it in 2-5 goes
            System.out.print("Well done!\n");
            break;
          } else if (i == 6){ // If the player guesses it on the last go
            System.out.print("That was a close call!\n");
            break;
          }
          // If the player failed to guess correctly
        } if (i == 6  && (!guess.matches(target))){ 
          System.out.print("Nope - Better luck next time!\n");
          break;
        }
      }
    }


  // TODO: Implement save() method, with a String parameter
  public void save(String filename) throws IOException{
    // Setup a path variable reading from filename  
    Path path = Paths.get(filename);
    // Using a try statement here for when it reaches the EOL 
    try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path))){
      // Prints the guess to the file
      for (int i = 0; i < guesses.size(); i++){
        out.println(guesses.get(i));
      }
    }
  }
}
