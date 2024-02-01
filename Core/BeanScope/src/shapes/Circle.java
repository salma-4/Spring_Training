package shapes;

import drawing.Draw2D;
import drawing.Draw3D;

public class Circle implements Shape {
    Draw2D draw2D;

    Draw3D draw3D;
    private int rad;

    public int getRad() {
        return rad;
    }

    public Circle() {
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public Circle(Draw2D draw2D ,Draw3D draw3D ){
        this.draw2D=draw2D;
        this.draw3D=draw3D;

    }

    @Override
    public void shapeName() {
        System.out.println("Name : circle");

    }

    @Override
    public void drawShape() {
      draw2D.draw("circle");
      draw3D.draw("circle");

    }
}
