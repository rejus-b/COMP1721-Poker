import java.util.Scanner;
import java.lang.Math;

public class Circle {

    private double radius;
    //static double PI = Math.PI; 

    public Circle(double r) {
        radius = r;
    }

    public double getRadius(){

        return radius;

    }

    public double area(){

        // Area = PI * r^2
        double circleArea;
        circleArea = Math.PI*(radius*radius);
        return(circleArea);

    }

    public double perimeter(){
        
        // Permiter = 2 * PI * r
        double doublePerimeter;
        doublePerimeter = 2*Math.PI*radius;
        return (doublePerimeter);

    }

}