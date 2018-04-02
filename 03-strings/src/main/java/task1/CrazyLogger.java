package task1;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class CrazyLogger {
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");
    private CrazyLogger(){
    }
    public static void INFO(String str){
        String res = new StringBuilder()
                .append(LocalDateTime.now().format(formatter))
                .append(String.format("-%s", str))
                .toString();
        System.out.println(res);
    }
}
