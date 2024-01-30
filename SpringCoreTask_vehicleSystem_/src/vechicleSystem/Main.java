package vechicleSystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vechicleSystem.config.Config;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(Config.class);
//        Car car= new Car();
//        car.setBrand("nnnnnn");
//        car.setId("2");
//        car.setType(Type.Car);
//        CarController carController=context.getBean("carController",CarController.class);
//        carController.save(car);
        // System.out.println(car.getBrand());
        context.close();
    }
}
