package task1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pen {
    String color;
    boolean mechanic;
    /*
    public Pen(String color, boolean mechanic) {
        this.color = color;
        this.mechanic = mechanic;
    }
    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", mechanic=" + mechanic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return mechanic == pen.mechanic &&
                Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, mechanic);
    }*/
}
