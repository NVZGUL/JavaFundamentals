package task3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class EncoderTest {

    @Test
    @SneakyThrows
    void encode() {
        new Encoder("/file.txt", "new_file.txt").encode();
    }

}