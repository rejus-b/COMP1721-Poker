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
    // Checks that the guess supplied is valid, and set it to the guessNumber
    if (num < 1 || num > 6){
      throw new GameException("Invalid guess number.");
    } else {
      guessNumber = num;
    }
  }


  // TODO: Implement constructor with int and String parameters
  public Guess(int num, String word){
    // Checks that the guessNumber supplied is valid
    if (num < 1 || num > 6){
      throw new GameException("Invalid guess number.");
      // Checks  that the input word consists only of letters and that the length of the input word is 5 characters
    } else if (word.matches("^[a-zA-Z]+") == false || word.length() != 5){
      throw new GameException("Invalid guess word.");
    } else {
      // Sets guessNumber and the chosenWord as upper cased
      guessNumber = num;
      chosenWord = word.toUpperCase();
    }
  }


  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){
    // Returns the guessNumber
    return(guessNumber);
  }


  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){
    // Returns the users input 
    return(chosenWord);
  }


  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){
    // Reads an input from the player then turns it to upper casee
    chosenWord = INPUT.nextLine();
    chosenWord = chosenWord.toUpperCase();
  }


  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){

    // My matches method will remove the letter from the array if it is found, that way it cannot be found again. 
    // USE INDEXOFF on the target string using the chosenword array as a return -1 statement would mean that it is not present
  
    // Sets all the ANSI escape codes as variables for 
    String green = "\033[30;102m ";
    String yellow = "\033[30;103m ";
    String white = "\033[30;107m ";
    String closeColour = " \033[0m";

    // Set a string builder, like a regular string but is seen as more mutable. 
    StringBuilder outputString = new StringBuilder();

    //Sets the name of the for loop as loop
    loop:
    // This loop is meant to loop through all of the chosenWord charaters
    for (int i = 0; i < 5; i++){
      // If the the target character and chosenWord character match
      if (target.charAt(i) == chosenWord.charAt(i)){ 
        // Append the green highlight and current letter to the stringbuilder
        outputString.append(green + chosenWord.charAt(i) + closeColour);
        // Remove the letter that is being appended from the target
        target = target.substring(0,i) + "." + target.substring(i+1,5);
        continue loop;
      // If the target character and the chosenWord character dont match
      } else{
        // This loops the green check again as without it some green pairs would be skipped over
        if (target.charAt(i) == chosenWord.charAt(i)){ 
          outputString.append(green + chosenWord.charAt(i) + closeColour);
          target = target.substring(0,i) + "." + target.substring(i+1,5);
          continue loop;
        }

        // If the current letter of the chosenWord is not found in the target start yellow finder loop
        if (target.indexOf(chosenWord.charAt(i)) != -1){
          for (int j = 0; j < 5; j++){

            // If two characters pairs in different locations match then apply a yellow ANSI code
            if (chosenWord.charAt(i) == target.charAt(j)){
              outputString.append(yellow + chosenWord.charAt(i) + closeColour);
              // Remove the letter that just got checked from the target word
              target = target.substring(0,target.lastIndexOf(chosenWord.charAt(i))) + "." + target.substring(target.lastIndexOf(chosenWord.charAt(i))+1,5);
              continue loop;
            }
          }
        }
        // If no yellow was applied, make it white
        else{
          outputString.append(white + chosenWord.charAt(i) + closeColour);
        }
      }
    }
    // Return the final string
    return (outputString.toString());
  }
    

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target){
    // If the chosenwords has the same value as the target return true, else return false
    if (chosenWord.equals(target)){
      return(true);
    } else {
      return(false);
    }
  }
}
