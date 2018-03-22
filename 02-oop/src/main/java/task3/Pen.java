package task3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pen extends Stationary {
    boolean mechanic;
    public Pen() {
        mechanic = false;
        super.setPrice(28.0);
        super.setName("pen");
    }
    public Pen(boolean mechanic, double price) {
        this.mechanic = mechanic;
        super.setPrice(price);
        super.setName("pen");
    }
}
