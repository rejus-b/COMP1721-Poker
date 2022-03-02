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
    chosenWord = chosenWord.toUpperCase();
  }


  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target){

    
    //HELLO 
    //LELOL // First L is yellow, second L is green, third L is grey

    // My matches method will remove the letter from the array if it is found, that way it cannot be found again. 
    // An alternative idea would be too do a count of all the letters from the start and then remove it from a total count 

    // Remove the letter from the target word once its found 


    // char [] targetArray = target.toCharArray();
    // char [] chosenWordArray = chosenWord.toCharArray();

    String green = "\033[30;102m ";
    String yellow = "\033[30;103m ";
    String white = "\033[30;107m ";
    String closeColour = " \033[0m";

    StringBuilder outputString = new StringBuilder();

    loop:
    for (int i = 0; i < 5; i++){ // Find full matches
      if (target.charAt(i) == chosenWord.charAt(i)){ 
        outputString.append(green + chosenWord.charAt(i) + closeColour);
        target = target.substring(0,i) + "." + target.substring(i+1,5);
      } else{
        //char charChosenWord = chosenWord[i];
        if (target.indexOf(chosenWord.charAt(i)) != -1){
          outputString.append(yellow + chosenWord.charAt(i) + closeColour);
          target = target.substring(0,target.indexOf(chosenWord.charAt(i))) + "." + target.substring(target.indexOf(chosenWord.charAt(i))+1,5);
          //continue loop;
                System.out.println("\n ");
        System.out.println(target);
        System.out.println("\n ");
        
        }
        else{
          outputString.append(white + chosenWord.charAt(i) + closeColour);
        }
        // System.out.println("\n ");
        // System.out.println(target);
        // System.out.println("\n ");
      }
    }

    // for (int i = 0; i < 5; i++){ // Find full matches
    //   if (chosenWordArray[i] == targetArray[i]){   // All match
    //     returnString.append(green + chosenWordArray[i] + closeColour);
    //     //chosenWordArray[i] = '.';
    //   } else if (chosenWordArray.indexOf(targetArray) != -1){
    //     returnString.append(yellow + chosenWordArray[i] + closeColour);
    //   }
      
    // USE INDEXOFF on the target string using the chosenword array as a return -1 statement would mean that it is not present, error checking later\ 


      // for (int j = 0; j < 5; j++){
      //    if (i != j){
      //     if (chosenWordArray[i] == targetArray[j]){
      //       returnString.append(yellow + chosenWordArray[i] + closeColour);
      //       chosenWordArray[i] = '.';
      //       break;
      //     }
      //   }
        
      // }

      //returnString.append(white + chosenWordArray[i] + closeColour);
    
    System.out.println("\n\n\n ");
    System.out.println(outputString.toString());
    System.out.println("\n\n\n ");
    return (outputString.toString());
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
