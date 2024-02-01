package shapes;

import org.springframework.stereotype.Component;

@Component
public class Square implements  Shape{
    private double len;
    @Override
    public void getArea(double len) {
        System.out.println("the area of Square : "+len*len);
    }
}
