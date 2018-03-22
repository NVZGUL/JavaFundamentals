package task3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Scissors extends Stationary {
    String material;
    public Scissors(){
        super.setName("scissors");
        super.setPrice(45d);
        this.material = "metal";
    }

    public Scissors(String material, double price) {
        super.setPrice(price);
        super.setName("scissors");
    }
}
