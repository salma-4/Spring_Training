package vechicleSystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
public class Bike  implements Vehicle{
    private String Id;
    private String brand;
    private Type type;

    public Bike(String id, String brand, Type type) {
        this.Id = id;
        this.brand = brand;
        this.type = type;
    }
}
