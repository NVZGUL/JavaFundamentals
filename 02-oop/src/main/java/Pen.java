import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Pen {
    private @Setter @Getter String color;
    private @Setter @Getter boolean mechanic;

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
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", mechanic=" + mechanic +
                '}';
    }
}
