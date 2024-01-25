package shapes;

import drawing.Draw2D;
import drawing.Draw3D;

public class Square implements Shape {

        Draw2D draw2D;
        Draw3D draw3D;
        private int len;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public void setDraw2DForSquare(Draw2D draw2D) {
        this.draw2D = draw2D;
    }

    public void setDraw3DForSquare(Draw3D draw3D) {
        this.draw3D = draw3D;
    }

    @Override
    public void shapeName() {
        System.out.println("name : Square");
    }

    @Override
    public void drawShape() {
     draw2D.draw("Square");
     draw3D.draw("Square");
    }
}
