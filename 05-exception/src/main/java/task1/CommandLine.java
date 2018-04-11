package task1;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLine {
    private final static String currentDir = System.getProperty("user.dir");
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            commandHandler(scanner.nextLine());
        }
    }

    private static void commandHandler(String input) {
        List<String> commands = Arrays.asList(input.split(" "));
        if (commands.remove(0).equals("dir"))
            dir();
        if (commands.remove(0).equals("write"))
            write(commands.remove(1), commands.remove(2));
        if (commands.remove(0).equals("rm"))
            rm(commands.remove(1));
    }

    private static void dir() {
        File file = new File(currentDir);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                System.out.println("/"+f.getName());
            if (f.isFile())
                System.out.println(f.getName());
        }
    }

    private static Path getPath(String dir) {
        return dir == ".." ? Paths.get(currentDir).getParent() : Paths.get(currentDir+"/"+dir);
    }

    @SneakyThrows
    private static void write(String arg1, String arg2) {
        if (!Files.exists(getPath(arg1))) {
            throw new FileNameException(getPath(arg1));
        }
        FileWriter fileWriter = new FileWriter(getPath(arg1).toString());
        fileWriter.write(arg2);
        fileWriter.close();
    }

    private static void rm(String arg1) {
        if (Files.exists(Paths.get(currentDir+"/"+arg1))) {
            File file = new File(Paths.get(currentDir+"/"+arg1).toString());
            file.delete();
        }
    }
}
