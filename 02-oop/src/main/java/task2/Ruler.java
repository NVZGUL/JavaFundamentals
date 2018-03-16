package task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ruler implements Stationery {
    double price;
    double size;

    @Override
    public double price() {
        return price;
    }
}
