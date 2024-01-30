package vechicleSystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
public class Car  implements Vehicle{
    private String Id;
    private String brand;
    private Type type;
    public Car(){

    }

    public Car(String id, String brand, Type type) {
        this.Id = id;
        this.brand = brand;
        this.type = type;
    }
}
