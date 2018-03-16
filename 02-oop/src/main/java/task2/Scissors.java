package task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Scissors implements Stationery {
    @Getter String material;
    @Getter double size;
    double price;

    @Override
    public double price() {
        return price;
    }
}
