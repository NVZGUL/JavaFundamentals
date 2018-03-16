package task2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    private List<Worker> workers;

    @Test
    void totalPriceOfStationary() {
        List<Stationery> workerItems = Arrays.asList(
                new Scissors("metal", 28, 5),
                new Ruler(2, 32));
        Worker w1 = new Worker(workerItems);
        assertEquals(7,w1.totalPriceOfStationary());
    }
}