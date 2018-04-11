package task1;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
class QuerieTest {
    Querie q = new Querie();

    @Test
    @SneakyThrows
    void select(){
        assertThat(q.select().remove(0).getFirstName(), is("Jose"));
    }

    @Test
    @SneakyThrows
    void insert() {
        val p = new Person(
                "Alioth",
                "Smith",
                true,
                LocalDate.of(2013, Month.APRIL, 11),
                "test@mail.com",
                "yeyeyey",
                "Tet 1, 123",
                "+789322021");
        assertThat(q.insert(p), is(1));
        assertThat(q.select().remove(1).getFirstName(), is("Alioth"));
    }

    @Test
    @SneakyThrows
    void drop() {
        assertThat(q.dropTable(), is(0));
    }
}