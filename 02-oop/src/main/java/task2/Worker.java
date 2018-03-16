package task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Worker {
    List<Stationery> workSpaceItems;

    double totalPriceOfStationary() {
        return workSpaceItems.stream().mapToDouble(Stationery::price).sum();
    }
}
