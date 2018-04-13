package task1;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JavaWordAnalyzerTest {

    @Test
    @SneakyThrows
    void anylyzeTestFile(){
        Map<JavaKeywords, Integer> result = Map.of(
                JavaKeywords.PUBLIC, 2,
                JavaKeywords.CLASS, 1,
                JavaKeywords.STATIC, 1,
                JavaKeywords.PACKAGE, 1,
                JavaKeywords.VOID, 1,
                JavaKeywords.INT, 1);
        assertThat(new JavaWordAnalyzer("Test").getAllKeywordsCount(), is(result));
    }
}