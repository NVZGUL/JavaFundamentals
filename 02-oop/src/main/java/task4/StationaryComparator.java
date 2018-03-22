package task4;

import task3.Stationary;

import java.util.Comparator;

public final class StationaryComparator {
    private StationaryComparator() {}
    public static Comparator<Stationary> byName() {
        return new StationaryNameComparator();
    }
    public static Comparator<Stationary> byPrice() {
        return new StationaryPriceComparator();
    }
    public static Comparator<Stationary> byPriceAndName() {
        return new StationaryPriceAndNameComparator();
    }
}
