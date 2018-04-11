package task3;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Parser {

    String path;

    @SneakyThrows
    public Parser(String path) {
        File file = new File(path);
        if (!file.exists() || file.isDirectory())
            throw new FileNotFoundException();
        this.path = path;
    }

    @SneakyThrows
    public String fromStreamToString(){
        FileInputStream fileInputStream = new FileInputStream(path);
        StringBuilder sb = new StringBuilder();
        try(val iS = new InputStreamReader(fileInputStream, "Cp1251")) {
            int i = iS.read();
            while (i != -1) {
                sb.append((char) i);
                i = iS.read();
            }
            return sb.toString();
        }
    }

    public String findPictures(String text) {
        Pattern p = Pattern.compile("[А-ЯA-Z].+[.!;?]");
        Matcher m = p.matcher(text);

        Pattern picture = Pattern.compile("(\\(Рис\\. \\d\\))+");
        Matcher pictureM = picture.matcher(text);

        StringBuilder sb = new StringBuilder();

        while (m.find()){
            pictureM = picture.matcher(m.group());
            if (pictureM.find()) {
                sb.append(m.group() + "\n");
            }
        }

        return sb.toString();
    }

    public boolean isSequal(String text) {
        Pattern p = Pattern.compile("(\\(Рис\\. \\d\\))[.]+(\\(Рис\\. \\d\\))");
        Matcher m = p.matcher(text);
        boolean flag = true;
        while (m.find()) {
            if (m.group().charAt(m.group().length()-1) <= m.group().charAt(7)){
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}
