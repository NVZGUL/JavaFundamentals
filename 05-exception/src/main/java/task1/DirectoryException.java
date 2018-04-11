package task1;

public class DirectoryException extends Throwable {
    public DirectoryException(String path) {
        System.out.println("Directory " + path + " does not exist");
    }
}
