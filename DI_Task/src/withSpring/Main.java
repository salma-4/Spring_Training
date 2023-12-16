package withSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
      Shape circle=  container.getBean("circle",Shape.class);
      circle.shapeName();
      circle.drawShape();
      Shape rectangle = container.getBean("rectangle",Shape.class);
      rectangle.shapeName();
      rectangle.drawShape();

 }
}