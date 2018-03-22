package task4;

import lombok.val;
import task3.Stationary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StationaryPriceAndNameComparator implements Comparator<Stationary> {
    @Override
    public int compare(Stationary o1, Stationary o2) {
        List<Comparator<Stationary>> lst  = Arrays.asList(
                new StationaryPriceComparator(),
                new StationaryNameComparator());
        for (val comparator : lst) {
            int res = comparator.compare(o1, o2);
            if (res != 0) {
                return res;
            }
        }
        return 0;
    }
}
