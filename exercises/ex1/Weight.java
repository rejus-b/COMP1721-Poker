import java.util.Scanner;

class Weight {
      public static void main(String[] args) {


        System.out.print("Enter weight in kilograms: ");
        Scanner userInput = new Scanner(System.in);
        double kgWeight = userInput.nextInt();
        

        System.out.printf("Equivalent imperial weight is %.1f lb %.1f oz", kgWeight, kgWeight);
    }
}