import java.util.Scanner;

class Spheroid {
    public static void main(String[] args){

        double eqRadius, poRadius, eccentricity, volume;
        double pi = Math.PI;

        // Scanning for equitorial radius
        System.out.print("Enter equitorial radius in km: ");
        Scanner userInput = new Scanner(System.in);
        eqRadius = userInput.nextDouble();

        // Scanning for polar radius
        System.out.print("Enter polar radius in km: ");
        userInput = new Scanner(System.in);
        poRadius = userInput.nextDouble();

        //Math.pow(num, power);
        // Calculating eccentricity and volume
        eccentricity = Math.sqrt(1-(Math.pow(poRadius,2)/Math.pow(eqRadius,2)));
        volume = (4*pi*Math.pow(eqRadius,2)*poRadius) / 3;
        
        // Outputs
        System.out.printf("Eccentricity = %.3f\n", eccentricity);
        System.out.printf("Volume = %g cubic km", volume);
        
    }
}