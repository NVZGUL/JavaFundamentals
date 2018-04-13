package task1;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class JavaWordAnalyzer {
    Map<JavaKeywords, Integer> res = new HashMap<>();

    String name;

    public JavaWordAnalyzer(String name) {
        this.name = name;
    }

    @SneakyThrows
    public Map<JavaKeywords, Integer> getAllKeywordsCount() {
        val name = String.format("/%s.java", this.name);
        Scanner scanner = new Scanner(JavaWordAnalyzer.class.getResourceAsStream(name));
        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            for (JavaKeywords kw : JavaKeywords.values()) {
                if (str.contains(kw.toString().toLowerCase())) {
                    if (res.containsKey(kw))
                        res.put(kw, res.get(kw) + 1);
                    else
                        res.put(kw, 1);
                }
            }
        }
        return res;
    }
}
