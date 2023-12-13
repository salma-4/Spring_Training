import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      /*  Shape s= new Circle();
     System.out.print((double)s.calcArea(2));*/
        ApplicationContext container=new ClassPathXmlApplicationContext("applicationContext.xml");
      
        Shape s=container.getBean("circle",Shape.class);
        System.out.println(s.calcArea(2));
      }
}