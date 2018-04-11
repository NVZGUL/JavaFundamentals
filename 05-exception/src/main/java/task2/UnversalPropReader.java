package task2;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.*;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnversalPropReader {

    public static Properties read(String fileName) throws IOException {
        Properties properties = new Properties();
        val name = String.format("/%s.properties", fileName);
        InputStream inputStream = UnversalPropReader.class.getResourceAsStream(name);
        properties.load(inputStream);
        return properties;
    }

}
