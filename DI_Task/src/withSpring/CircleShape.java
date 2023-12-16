package withSpring;

import withoutSpring.DrawTool;

public class CircleShape implements Shape{
    Draw2D drawTool;
   public CircleShape(Draw2D drawTool){
       this.drawTool=drawTool;
   }
    @Override
    public void shapeName() {
        System.out.println("Name :circle");
    }

    @Override
    public void drawShape() {
       drawTool.draw("circle");
    }
}
