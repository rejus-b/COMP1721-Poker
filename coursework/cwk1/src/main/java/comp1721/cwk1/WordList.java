package comp1721.cwk1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class WordList {

  private List<String> words = new ArrayList<>();

  // TODO: Implement constructor with a String parameter
  public WordList(String filename) throws IOException{

    Scanner input = new Scanner(Paths.get(filename));

        while (input.hasNextLine()){
            String value = input.nextLine();                
            words.add(value);
        }
        input.close();
        
    }



  // TODO: Implement size() method, returning an int
  public int size(){
    return(words.size());
  }


  // TODO: Implement getWord() with an int parameter, returning a String
  public String getWord(int n) throws GameException{ // gameNumber is the total amount of possible games e.g. 0 to the max number of words.
    if (n < 0 || n > words.size() - 1){
      throw new GameException("Invalid game number.");
    } else{
      return(words.get(n));
    }
  }
}
