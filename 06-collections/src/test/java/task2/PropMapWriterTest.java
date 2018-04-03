package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PropMapWriterTest {
    private PropMapWriter pmw;
    @BeforeEach
    void setUp() {
        pmw = new PropMapWriter();
    }

    @Test
    void get() {
        Map<String, String> m = new HashMap<>();
        m.put("t","uu");
        m.put("r", "tt");
        m.put("a","1");
        m.put("author", "Slava");
        m.put("course", "JavaFundamentals");

        assertThat(pmw.get(), is(m));
    }
}