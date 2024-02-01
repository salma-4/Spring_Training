package shapes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle1 =context.getBean("circle", Circle.class);
        circle1.shapeName();
        circle1.drawShape();
        Circle circle2 =context.getBean("circle", Circle.class);
        System.out.println(circle1+"  "+circle2); // same ref ==>def ->singleton
        System.out.println("------------------square prototype-------------------------");
        Square square1 = context.getBean("square", Square.class);
        Square square2 = context.getBean("square",Square.class);
        square1.shapeName();
        square1.drawShape();
        System.out.println(square1+ "   "+square2); // diff ref ==> prototype


    }
}
