import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Circle implements Writeable{

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

  public void writeTo(Writer destination) throws IOException{

    String outputString = String.format("Circle: r=%.4f\n", getRadius());
    destination.write(outputString);
    destination.close();

  }

}