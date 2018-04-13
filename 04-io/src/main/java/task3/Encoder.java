package task3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Encoder {
    String fileNameIn;
    String fileNameOut;

    @SneakyThrows
    public void encode() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Encoder.class.getResourceAsStream(fileNameIn),
                        "UTF-8"));
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(Encoder.class.getResource("/").getFile()+fileNameOut), "UTF16"));
        String str;
        while ( (str = reader.readLine()) != null) {
            writer.write(str + "\n");
        }
        reader.close();
        writer.close();
    }
}
