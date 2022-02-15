public class Circle {

    private double radius;
    static double PI = Math.PI; 

    public Circle(double r) {
        radius = r;
    }

    public double getRadius(){

        return radius;

    }

    public double area(){

        // Area = PI * r^2
        return(PI*(Math.pow(radius,2)));

    }

    public double perimiter(){
        
        // Permiter = 2 * PI * r
        return (2*PI*radius);

    }

}