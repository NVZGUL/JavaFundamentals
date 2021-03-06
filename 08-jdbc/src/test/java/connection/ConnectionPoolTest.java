package connection;

import connection.ConnectionPool;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class ConnectionPoolTest {

    static String SQL =
            "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

    @Test
    @SneakyThrows
    @DisplayName("Get method works correctly")
    void get() {
        @Cleanup val connectionPool = new ConnectionPool();

        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            if (resultSet.next())
                assertThat(resultSet.getString("first_name"), is("Jose"));
        }
    }
}