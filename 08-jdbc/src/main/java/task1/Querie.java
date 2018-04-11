package task1;

import connection.ConnectionPool;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Querie {
    String SQL;
    ConnectionPool connectionPool = new ConnectionPool();

    @SneakyThrows
    public List<Person> select() {
        val persons = new ArrayList<Person>();
        SQL = "select first_name, " +
                "last_name, " +
                "permission, " +
                "dob, " +
                "email, " +
                "password, " +
                "address, " +
                "telephone from Person";
        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()){
                persons.add(new Person(resultSet));
            }
            return persons;
        }
    }

    @SneakyThrows
    public int insert(Person person){
        SQL = String.format(
                "INSERT INTO PERSON (" +
                        "first_name, " +
                        "last_name, " +
                        "permission, " +
                        "dob, email, " +
                        "password, " +
                        "address, " +
                        "telephone) VALUES (%s);", person.toString());
        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement()) {
            return statement.executeUpdate(SQL);
        }
    }

    @SneakyThrows
    public int dropTable() {
        SQL = "DROP TABLE PERSON";
        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement()) {
            return statement.executeUpdate(SQL);
        }
    }
}
