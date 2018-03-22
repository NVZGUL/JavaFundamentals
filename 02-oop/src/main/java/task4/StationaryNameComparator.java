package task4;

import task3.Stationary;

import java.util.Comparator;

class StationaryNameComparator implements Comparator<Stationary> {
    @Override
    public int compare(Stationary o1, Stationary o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
