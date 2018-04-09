package task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertiesReader extends Thread {
    Map<String, String> properties;
    File file;
    @Override
    public void run() {
        Properties prop = new Properties();
        try(FileInputStream inputStream = new FileInputStream(file)) {
            prop.load(inputStream);
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()){
                String key = (String) e.nextElement();
                properties.put(key, prop.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, String> m = Collections.synchronizedMap(new HashMap<>());
        List<PropertiesReader> lst = Arrays
                .stream(new File("src/main/resources/task2").listFiles())
                .filter(f->f.getName().endsWith(".properties"))
                .map(f -> new PropertiesReader(m, f))
                .collect(Collectors.toList());
        for (PropertiesReader t : lst) {
            t.start();
        }
        try {
            for (PropertiesReader t : lst) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
