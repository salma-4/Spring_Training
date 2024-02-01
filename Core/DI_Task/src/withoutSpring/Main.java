package withoutSpring;

public class Main {
    public static void main(String[] args) {
        CircleShape circle = new CircleShape();

        circle.shapeName();
        circle.drawShape();
        RectangleShape rectangle = new RectangleShape();
         rectangle.shapeName();
         rectangle.drawShape();
 }
}