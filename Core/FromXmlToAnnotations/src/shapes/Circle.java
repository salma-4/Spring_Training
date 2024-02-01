package shapes;

import org.springframework.stereotype.Component;

@Component("circleShape")
public class Circle implements Shape{
    private double rad;

    public double getRad() {
        return rad;
    }

    public void setRad(double rad) {
        this.rad = rad;
    }

    @Override
    public void getArea(double rad) {
        System.out.println("the area of the circle :"+Math.PI*rad*rad);
    }
}
