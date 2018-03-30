package task1;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class CrazyLogger {
    final StringBuilder sb = new StringBuilder();
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");
    private CrazyLogger(){
    }
    private boolean addMsg(String msg){
        sb.append(LocalDateTime.now().format(formatter));
        sb.append(String.format("-%s", msg));
        return true;
    }
    public static void INFO(String str){
        CrazyLogger cl = new CrazyLogger();
        if (cl.addMsg(str)){
            System.out.println(cl.sb.toString());
        }
    }
}
