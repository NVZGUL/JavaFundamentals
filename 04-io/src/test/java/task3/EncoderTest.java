package task3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    @Test
    @SneakyThrows
    void encode() {
        new Encoder("/file.txt", "new_file.txt").encode();
    }

}