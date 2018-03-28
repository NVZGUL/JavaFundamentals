package task7;

import java.lang.annotation.Documented;

@Documented
public @interface MyAnnotation {
    String author();
    String date();
}
