public class CheckPassword {
  public static boolean longEnough(String password) {

    if (password.length() >= 12){
      return true;
    }
    else {
      return false;
    }

  }

  public static boolean atLeastTwoDigits(String password) {
    
    int count = 0;
    char [] passwordChar = password.toCharArray();

    for (int i = 0; i < password.length(); i++){
      //System.out.println(password.substring(i,i+1));
      if (Character.isDigit(passwordChar[i]) == true){
        count++;
        if (count >= 2){
          return true;
        }
      }
    }

    return false;

  }

  public static void main(String[] args) {

    if (args.length == 0){
      System.out.println("Usage: java CheckPassword <password>");
      System.exit(1);
    }

    String password = args[0];
    if (longEnough(password) == false || atLeastTwoDigits(password) == false){
      System.out.println("Password is not valid");
    } else {
      System.out.println("Password is valid");
    }


    
    
    
  }
}
