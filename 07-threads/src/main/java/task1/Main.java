package task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * Method for generating threads
     * @param count > 0 - number of thread
     * @return List of threads with size count
     */
    private static List<TransferHandler> setThreads(int count) {
        List<TransferHandler> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lst.add(new TransferHandler());
        }
        return lst;
    }

    public static Map<String, Account> fromFileToMap(){
        String filePath = "src/main/resources/transaction.txt";
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            Scanner sc = new Scanner(inputStream);
            List<TransferHandler> lst = setThreads(3);
            while (sc.hasNextLine()) {
                for (TransferHandler t : lst) {
                    t.setLine(sc.nextLine());
                }
                for (TransferHandler t : lst) {
                    t.start();
                }
            }
            for (TransferHandler t : lst) {
                t.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Banks.lst;
    }
}
