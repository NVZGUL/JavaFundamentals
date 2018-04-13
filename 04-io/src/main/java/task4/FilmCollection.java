package task4;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmCollection implements Serializable {
    String fileName;
    @Getter List<Film> films = new ArrayList<>();

    FilmCollection(String fileName) {
        this.fileName = fileName;
    }

    @SneakyThrows
    public FilmCollection loadFilms() {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(fileName));
        FilmCollection filmCollection = (FilmCollection) objectInputStream.readObject();
        objectInputStream.close();
        return filmCollection;
    }

    @SneakyThrows
    public void saveFilms() {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }
}
