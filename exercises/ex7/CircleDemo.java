public class CircleDemo {

    public static void main(String [] args){
    
    double r = -2; // 5 Cm
    Circle circleObject = new Circle(r);

    System.out.printf("Radius  = %.5f", circleObject.getRadius());
    System.out.printf("Perimier = %.5f", circleObject.perimeter());
    System.out.printf("Perimier = %.5f", circleObject.area());

    }
}