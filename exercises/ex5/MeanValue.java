public class MeanValue {
  public static double meanValue(double[] data) {
  
    double total = 0;
    int i; // counter
    for (i = 0; i < data.length; i++){
      total = total + data[i];
    }

    return(total/data.length);

  }

  public static void main(String[] args) {

    if (args.length == 0){
      System.err.println("Usage: java MeanValue <values...>");
      System.exit(1);
    }

    int i; // counter
    double [] doubleArgs = new double[args.length];
    for (i = 0; i < args.length; i++){
      doubleArgs[i] = Double.parseDouble(args[i]);
      System.out.println(doubleArgs[i]);
    }

    System.out.printf("Mean value = %.3f", meanValue(doubleArgs));

  }
}
