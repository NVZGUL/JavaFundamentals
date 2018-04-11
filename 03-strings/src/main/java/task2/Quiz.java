package task2;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    Locale locale;
    PropertyResource pR;

    public Quiz(Locale locale) {
        this.locale = locale;
        this.pR = new PropertyResource(locale);
    }

    public String getAnswer(int n) {
        return pR.getResourceBundle().getString(String.valueOf(n));
    }

    public void startQuiz() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1+" - " + pR.getResourceBundle().getString("q" + String.valueOf(i+1)));
        }
    }
}
