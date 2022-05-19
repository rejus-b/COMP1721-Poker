import java.util.Scanner;
import java.lang.Math;

class Spheroid {
    public static void main(String[] args){

        double eqRadius, poRadius, eccentricity, volume;
        double pi = Math.PI;

        // Scanning for equitorial radius
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter equatorial radius in km: ");
        eqRadius = userInput.nextDouble();


        // Scanning for polar radius
        System.out.print("Enter polar radius in km: ");
        poRadius = userInput.nextDouble();

        // Errenous data handling
        if (eqRadius <= 0){
            System.out.println("Error: equatorial radius must be larger than 0");
            System.exit(1);
        }
        if (poRadius <= 0){
            System.out.println("Error: polar radius must be larger than 0");
            System.exit(1);
        }
        if (eqRadius < poRadius){
            System.out.println("Error: equatorial radius must be larger than polar radius");
            System.exit(1);
        }


        // Math.pow(num, power);
        // Calculating eccentricity and volume
        eccentricity = Math.sqrt(1-(Math.pow(poRadius,2)/Math.pow(eqRadius,2)));
        volume = (4*pi*Math.pow(eqRadius,2)*poRadius) / 3;
        
        // Outputs
        System.out.printf("Eccentricity = %.3f", eccentricity);
        System.out.println();
        System.out.printf("Volume = %g cubic km", volume);
        
    }
}