package comp1721.cwk1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.util.Scanner;


public class WordList {

  private List<String> words = new ArrayList<>();

  // TODO: Implement constructor with a String parameter
  public WordList(String filename) throws IOException{

    // Creates a scanner object called input that reads from the input filename
    Scanner input = new Scanner(Paths.get(filename));

        // While the file has another line read from it and store the value in an array list called words
        while (input.hasNextLine()){
            String value = input.nextLine();                
            words.add(value);
        }
        // Close the file after its no longer being used
        input.close();
    }



  // TODO: Implement size() method, returning an int
  public int size(){
    //Calls the inbuilt size function on words and return it
    return words.size();
  }


  // TODO: Implement getWord() with an int parameter, returning a String
  public String getWord(int n) throws GameException{
    // Checks that the gameNumber (n) is not less than 0 and it is not greater than the total amount of 
    if (n < 0 || n > words.size() - 1){
      // Throw an error if it tries to access an invalid game number
      throw new GameException("Invalid game number.");
    } else{
      // Return the word at the chosen gameNumber
      return words.get(n);
    }
  }
}
