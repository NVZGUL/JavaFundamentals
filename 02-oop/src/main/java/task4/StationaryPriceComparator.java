package task4;

import task3.Stationary;

import java.util.Comparator;

class StationaryPriceComparator implements Comparator<Stationary> {
    @Override
    public int compare(Stationary o1, Stationary o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
