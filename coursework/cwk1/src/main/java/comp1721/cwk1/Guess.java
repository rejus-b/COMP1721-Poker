package comp1721.cwk1;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Guess {

  private int guessNumber;
  private String chosenWord;

  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  // TODO: Implement constructor with int parameter
  public Guess(int num){
    if (num < 1 || num > 6){
      throw new GameException("Invalid guess number.");
    } else {
      guessNumber = num;
    }
  }


  // TODO: Implement constructor with int and String parameters
  public Guess(int num, String word){
    if (num < 1 || num > 6){
      throw new GameException("Invalid guess number.");
    } else if (word.matches("^[a-zA-Z]+") == false || word.length() != 5){
      throw new GameException("Invalid guess word.");
    } else {
      guessNumber = num;
      chosenWord = word.toUpperCase();
    }
  }


  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){

    return(1);
  }


  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){

    return("");
  }


  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){

  }


  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){

    return("");
  }


  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){

    return(true);
  }
}
