package task3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ruler extends Stationary {
    double size;
    public Ruler() {
        super.setName("ruler");
        super.setPrice(34d);
        size = 20d;
    }
    public Ruler(double size, double price) {
        super.setPrice(price);
        this.size = size;
    }
}
