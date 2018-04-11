package connection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Supplier;

@Value
@Getter(AccessLevel.NONE)
public class ConnectionFactory implements Supplier<Connection> {
    String driver;
    String url;
    String user;
    String password;

    @Getter(AccessLevel.PUBLIC)
    int poolSize;

    @Getter(AccessLevel.PUBLIC)
    String initScriptsPath;

    @Override
    @SneakyThrows
    public Connection get() {
        return DriverManager.getConnection(url, user, password);
    }
}
