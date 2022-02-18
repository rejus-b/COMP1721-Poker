import java.lang.Math;

public class Circle {

    private double radius;
    //static double PI = Math.PI; 

    public Circle() {

        radius = 1.0;

    }

    public Circle(double r) {

        if (r <= 0){
            throw new IllegalArgumentException("Invalid radius");
        }

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


    @Override 
    public String toString(){

        return String.format("Circle(radius=%.4f)", getRadius());
        //System.out.println(Circle.radius());
    
    }

    @Override
    public boolean equals(Object obj){

        // Override it so that equals is 0.00005 apart.
        double difference;
        Circle newCircle = (Circle) obj;
        difference = this.radius - newCircle.radius;
        System.out.println(difference);
        if (difference > -0.00005 && difference < 0.00005){
            return true;
        } else {
            return false;
        }

    }

}