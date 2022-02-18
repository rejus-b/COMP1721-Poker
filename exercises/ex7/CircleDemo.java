public class CircleDemo {

    public static void main(String [] args){
    
    Circle circleObject = new Circle(1.0);
    Circle circle2 = new Circle(1.00005);

    System.out.println(circleObject.equals(circle2));


    // System.out.printf("Radius  = %.5f", circleObject.getRadius());
    // System.out.printf("Perimier = %.5f", circleObject.perimeter());
    // System.out.printf("Perimier = %.5f", circleObject.area());

    // System.out.println(circleObject.toString());


    }
}