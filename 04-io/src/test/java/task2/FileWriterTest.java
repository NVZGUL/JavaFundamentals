package task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import task1.JavaWordAnalyzer;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    @Test
    @SneakyThrows
    void writeToFile() {
        new FileWriter(new JavaWordAnalyzer("Test").getAllKeywordsCount()).write();
        assertThat(Arrays.stream(
                new File(FileWriter.class.getResource("/").getFile()).listFiles()).map(File::getName)
                        .filter(f -> f.equals("File.txt"))
                        .findAny()
                        .orElse(""), is("File.txt"));
    }

}