package task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class UnversalPropReaderTest {
    @Test
    @SneakyThrows
    void readProperty(){
        assertThat(UnversalPropReader.read("test").getProperty("author"), is("me"));
    }

}