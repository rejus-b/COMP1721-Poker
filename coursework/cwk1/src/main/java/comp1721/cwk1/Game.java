package comp1721.cwk1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.temporal.ChronoUnit;
//import java.util.Date.*;

// Import chromium for dates dont use the reecomended stuff its jank

public class Game {

  private int gameNumber;
  private String target; 

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
    

  }


  // TODO: Implement save() method, with a String parameter
  public void save(String filename){

  }
}
