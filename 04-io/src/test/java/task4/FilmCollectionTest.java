package task4;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class FilmCollectionTest {
    private static List<Film> films;
    @BeforeAll
    static void setCollection() {
        Actor a1 = new Actor("Brad Pit", 55);
        Actor a2 = new Actor("Anjelina Djouli", 52);
        Film f1 = new Film("Mister and Misis Smith", Arrays.asList(a1,a2));
        Film f2 = new Film("Fight club", Collections.singletonList(a1));
        Film f3 = new Film("Lara Croft", Collections.singletonList(a2));
        films = Arrays.asList(f1,f2,f3);
    }
    @Test
    @SneakyThrows
    void saveCollection() {
        FilmCollection filmCollection = new FilmCollection("save.txt", films);
        filmCollection.saveFilms();
    }

    @Test
    @SneakyThrows
    void loadCollection() {
        FilmCollection filmCollection = new FilmCollection("save.txt")
                .loadFilms();
        assertThat(filmCollection.getFilms(), is(films));
    }
}