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


    char [] targetArray = target.toCharArray();
    char [] chosenWordArray = chosenWord.toCharArray();

    String green = "\033[30;102m ";
    String yellow = "\033[30;103m ";
    String white = "\033[30;107m ";
    String closeColour = " \033[0m";
    boolean found = false;

    StringBuilder outputString = new StringBuilder();

    loop:
    for (int i = 0; i < 5; i++){ // Find full matches
      if (target.charAt(i) == chosenWord.charAt(i)){ 
        outputString.append(green + chosenWord.charAt(i) + closeColour);
        target = target.substring(0,i) + "." + target.substring(i+1,5);
        // System.out.println(target);
        continue loop;
      } else{
        if (target.charAt(i) == chosenWord.charAt(i)){ 
          outputString.append(green + chosenWord.charAt(i) + closeColour);
          target = target.substring(0,i) + "." + target.substring(i+1,5);
          // System.out.println(target);
          continue loop;
        }
        //char charChosenWord = chosenWord.charAt(i)

        if (target.indexOf(chosenWord.charAt(i)) != -1){
          for (int j = 0; j < 5; j++){

            if (chosenWord.charAt(i) == target.charAt(j)){
              outputString.append(yellow + chosenWord.charAt(i) + closeColour);
              target = target.substring(0,target.lastIndexOf(chosenWord.charAt(i))) + "." + target.substring(target.lastIndexOf(chosenWord.charAt(i))+1,5);
              continue loop;
            }
          }

          // target = target.substring(0,target.lastIndexOf(chosenWord.charAt(i))) + "." + target.substring(target.lastIndexOf(chosenWord.charAt(i))+1,5);
        //   //continue loop;
        //         System.out.println("\n ");
        // System.out.println(target);
        // System.out.println("\n ");
        
        }
        else{
          outputString.append(white + chosenWord.charAt(i) + closeColour);
        }

        // System.out.println("\n ");
        // System.out.println(target);
        // System.out.println("\n ");
      }
    }


    // USE INDEXOFF on the target string using the chosenword array as a return -1 statement would mean that it is not present, error checking later\ 

    // loop:
    // for (int i = 0; i < 5; i++) {
    //   for (int j = 0; j < 5; j++) {
    //     if (chosenWordArray[i] == targetArray[j]) {
    //       if (i == j) {
    //         outputString.append(green + chosenWordArray[i] + closeColour);
    //         targetArray[j] = '.';
    //         continue loop;
    //       } else{
    //         outputString.append(yellow + chosenWordArray[i] + closeColour); 
    //         targetArray[j] = '.';
    //         continue loop;
    //       }
    //     }
    //     System.out.println(targetArray);
    //   }
    //     outputString.append(white + chosenWordArray[i] + closeColour);
    // }
    
    // return (outputString.toString());

    // loop:
    // for (int i = 0; i < 5; i++) {
    //   if (chosenWord.charAt(i) == chosenWord.charAt(target.indexOf(chosenWord.charAt(i)))) {
    //   for (int j = 0; j < 5; j++) {
    //     outputString.append(green + chosenWordArray[i] + closeColour);
    //     targetArray[j] = '.';
    //     continue loop;
    //   }
        
          // if (i == j) {
          //   outputString.append(green + chosenWordArray[i] + closeColour);
          //   targetArray[j] = '.';
          //   continue loop;
          // } 
          // else{
          //   outputString.append(yellow + chosenWordArray[i] + closeColour); 
          //   targetArray[j] = '.';
          //   continue loop;
          // }
        // }
        // System.out.println(targetArray);
      // }
        // outputString.append(white + chosenWordArray[i] + closeColour);
    
    
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
