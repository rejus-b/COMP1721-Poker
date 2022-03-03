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
    LocalDate today = LocalDate.now();
    LocalDate firstWordleDay = LocalDate.of(2021,Month.JUNE,19);

    long daysDifference = ChronoUnit.DAYS.between(firstWordleDay, today);
    gameNumber = (int) daysDifference;

    WordList words = new WordList(filename);
    target = words.getWord(gameNumber);

  }


  // TODO: Implement constructor with int and String parameters
  public Game(int num, String filename) throws IOException{
    gameNumber = num;

    WordList words = new WordList(filename);
    target = words.getWord(num);

  }


  // TODO: Implement play() method
  public void play(){
      System.out.printf("Wordle %d %n%n", gameNumber);

      for(int i = 1; i < 7; i++) {
        Guess guess = new Guess(i);
        System.out.printf("Enter guess (%d/6): ", guess.getGuessNumber());
        guess.readFromPlayer();
        Guess validateGuess = new Guess(i, guess.getChosenWord());
        System.out.println(guess.compareWith(target));
        guesses.add(guess.compareWith(target));

        if (guess.matches(target)){ // If its a first round guess
          if (i == 1){
            System.out.print("Superb - Got it in one!\n");
            break;
          } else if ((i > 1) && (i < 6)){ // 2-5 Guesses
            System.out.print("Well done!\n");
            break;
          } else if (i == 6){ // Last round guess
            System.out.print("That was a close call!\n");
            break;
          }
        } if (i == 6  && (!guess.matches(target))){ // Didnt guess correct
          System.out.print("Nope - Better luck next time!\n");
          break;
        }
      }
    }


  // TODO: Implement save() method, with a String parameter
  public void save(String filename) throws IOException{
    Path path = Paths.get(filename);
    try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path))){
      for (int i = 0; i < guesses.size(); i++){
        out.println(guesses.get(i));
      }
    }
  }
}
