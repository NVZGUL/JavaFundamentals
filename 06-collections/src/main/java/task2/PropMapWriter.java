package task2;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropMapWriter {
    static final List<File> files =
            Arrays.stream(new File("src/main/resources").listFiles())
                    .filter(f -> f.getName().endsWith(".properties"))
                    .collect(Collectors.toList());
    Properties prop = new Properties();
    InputStream input;
    public Map<String, String> get() {
        val m = new HashMap<String, String>();
        for (File f : files) {
            try {
                input = new FileInputStream(f.getPath());
                prop.load(input);
                Enumeration<?> e = prop.propertyNames();
                while (e.hasMoreElements()){
                    String key = (String) e.nextElement();
                    m.put(key, prop.getProperty(key));
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return m;
    }
}
