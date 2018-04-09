package task1;

import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferHandler extends Thread {
    @Setter String line;

    @Override
    public void run() {
        System.out.println("Thread started");
        String[] lst;
        double amount;
        if (line.contains("->")) {
            lst = line.replaceAll("\\s+", "").split("->");
            amount = Double.parseDouble(lst[2]);
            Banks.lst.get(lst[0]).withdraw(amount);
            Banks.lst.get(lst[1]).deposit(amount);
        }
        if (line.contains("<-")) {
            lst = line.replaceAll("\\s+", "").split("<-");
            amount = Double.parseDouble(lst[2]);
            Banks.lst.get(lst[0]).deposit(amount);
            Banks.lst.get(lst[1]).withdraw(amount);
        }
    }
}
