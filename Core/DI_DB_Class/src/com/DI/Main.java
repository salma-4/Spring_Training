package com.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = container.getBean("carBean",Car.class);
        car.setBrand("BMW");
        car.saveDataIntoDB(car);
        Plane plane = container.getBean("planeBean",Plane.class);
        car.setBrand("boeng");
        car.saveDataIntoDB(plane);

    }
}
