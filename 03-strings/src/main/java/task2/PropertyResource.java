package task2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Locale;
import java.util.ResourceBundle;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyResource {
    ResourceBundle resourceBundle;

    public PropertyResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("Quiz", locale);
    }
}
