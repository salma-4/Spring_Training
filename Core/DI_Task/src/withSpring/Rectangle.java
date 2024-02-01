package withSpring;

public class Rectangle implements Shape{
    public Draw3D draw3D;
    public Draw2D draw2D;
    @Override
    public void shapeName() {
        System.out.println("Name : rectangle");
    }
    public void setDrawRectangleShape3D(Draw3D draw3D){
        this.draw3D=draw3D;
    }
    public void setDrawRectangleShape2D(Draw2D draw2D){
        this.draw2D=draw2D;
    }
    @Override
    public void drawShape() {
      draw3D.draw("rectangle");
      draw2D.draw("rectangle");
    }
}
