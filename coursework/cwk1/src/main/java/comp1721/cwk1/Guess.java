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
    return(guessNumber);
  }


  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){
    return(chosenWord);
  }


  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){
    chosenWord = INPUT.nextLine();
  }


  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){

    
    //HELLO 
    //LELOL // First L is yellow, second L is green, third L is grey

    // My matches method will remove the letter from the array if it is found, that way it cannot be found again. 
    // An alternative idea would be too do a count of all the letters from the start and then remove it from a total count 

    // Remove the letter from the target word once its found 


    char [] targetArray = target.toCharArray();
    char [] chosenWordArray = chosenWord.toCharArray();

    String green = "\033[30;102m ";
    String yellow = "\033[30;103m ";
    String white = "\033[30;107m ";
    String closeColour = " \033[0m";


    StringBuilder returnString = new StringBuilder();

    for (int i = 0; i < 5; i++){ // Find full matches
      if (chosenWordArray[i] == targetArray[i]){   //green
        returnString.append(green + chosenWordArray[i] + closeColour);
      }


      
    }
    return (returnString.toString());
  }


  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){
    if (chosenWord.equals(target)){
      return(true);
    } else {
      return(false);
    }
  }
}
