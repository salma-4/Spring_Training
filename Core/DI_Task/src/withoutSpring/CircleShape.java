package withoutSpring;

public class CircleShape implements Shape{
    @Override
    public void shapeName() {
        System.out.println("Name : circle");

    }
    public DrawTool drawShape;
    public CircleShape(){
        this.drawShape=new DrawTool();
    }
    @Override
    public void drawShape() {
            drawShape.draw("circle");
    }
}
