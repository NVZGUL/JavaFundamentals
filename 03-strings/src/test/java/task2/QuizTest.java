package task2;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    @Test
    @SneakyThrows
    void QuestionsTest() {
        new Quiz(new Locale("ru", "RU")).startQuiz();
        new Quiz(new Locale("en", "US")).startQuiz();
    }

    @Test
    void checkAnswers() {
        assertThat(new Quiz(new Locale("en", "US")).getAnswer(1), is("Cezar"));
    }
}