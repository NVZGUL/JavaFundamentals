package task1;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class FileNameException extends FileNotFoundException {
    public FileNameException(Path path) {
        super("File " + path + " not found");
    }
}
