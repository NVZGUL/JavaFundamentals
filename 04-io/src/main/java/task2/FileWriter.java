package task2;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import task1.JavaKeywords;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileWriter {
    Map<JavaKeywords, Integer> m;
    final static String fileName = "File.txt";

    FileWriter(Map<JavaKeywords, Integer> m) {
        this.m = m;
    }

    @SneakyThrows
    public void write() {
        FileOutputStream outputStream = new FileOutputStream(
                FileWriter.class.getResource("/").getFile() + fileName);
        outputStream.write(m.toString().getBytes());
        outputStream.close();
    }
}
