public class MeanValue {
  public static double meanValue(double[] data) {
  }

  public static void main(String[] args) {

    if (args.length == 0){
      System.err.println("Usage: java MeanValue <values...>");
      System.exit(1);
    }

    int i; // counter
    double doubleArgs = [];
    for (i = 0; i < args.length - 1; i++){
      doubleArgs[i] = Double.parseDouble(args[i]);
    }

    System.out.printf(MeanValue[doubleArgs]);

  }
}
