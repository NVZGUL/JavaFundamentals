package connection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.Connection;
import java.util.function.Consumer;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PooledConnection implements Connection {
    Consumer<PooledConnection> closer;

    @Delegate(excludes = Closeable.class)
    Connection connection;

    @Override
    public void close() {
        closer.accept(this);
    }

    @SneakyThrows
    public void reallyClose() {
        connection.close();
    }
}
