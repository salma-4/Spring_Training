package withoutSpring;

public class RectangleShape  implements Shape {
    @Override
    public void shapeName() {
        System.out.println("Name : rectangle");

    }

    public DrawTool drawShape;

    public RectangleShape() {
        this.drawShape = new DrawTool();
    }

    @Override
    public void drawShape() {
        drawShape.draw("rectangle");
    }
}
