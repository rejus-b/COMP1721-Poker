import java.util.Scanner;

class Weight {
    public static void main(String[] args) {
        
        int pounds;
        double ounces, kgWeight;

        // For getting the user input
        System.out.print("Enter weight in kilograms: ");
        Scanner userInput = new Scanner(System.in);
        kgWeight = userInput.nextDouble();

        // Converting kg to lbs and oz
        ounces = kgWeight * 35.27;
        pounds = (int) (ounces / 16); 
        ounces = ounces % 16;

        // %d is formatting for decimal integer
        System.out.printf("Equivalent imperial weight is %d lb %.1f oz", pounds, ounces);
    }
}