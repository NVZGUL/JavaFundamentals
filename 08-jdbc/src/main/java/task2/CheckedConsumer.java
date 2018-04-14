package task2;

import java.util.function.Consumer;

import static lombok.Lombok.sneakyThrow;

public interface CheckedConsumer<T> extends io.vavr.CheckedConsumer<T> {
    default Consumer<T> unchecked() {
        return t -> {
            try {
                this.accept(t);
            } catch (Throwable e) {
                throw sneakyThrow(e);
            }
        };
    }
}
