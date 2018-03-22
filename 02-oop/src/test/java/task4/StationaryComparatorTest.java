package task4;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task3.Pen;
import task3.Ruler;
import task3.Scissors;
import task3.Stationary;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StationaryComparatorTest {
    private List<Stationary> lst;
    @BeforeEach
    void setUp() {
        lst = Arrays.asList(
                new Pen(),
                new Scissors(),
                new Pen(true, 11d),
                new Ruler()
        );
    }

    @Test
    void compareObjects(){
        Comparator<Stationary> comparator = StationaryComparator.byPriceAndName();
        Set<Stationary> set = new TreeSet<>(comparator);
        set.addAll(lst);
        List<Stationary> set1 = Arrays.asList(
                new Pen(true, 11d),
                new Pen(),
                new Ruler(),
                new Scissors()
        );
        assertThat(new ArrayList<>(set), is(set1));
    }
}
