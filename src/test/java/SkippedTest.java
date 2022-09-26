import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTest {

    @Test
    @Disabled
    void test00() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test01() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test02() {
        assertTrue(true);
    }

    @Test
    @Disabled("reason")
    void test03() {
        assertTrue(true);
    }
}
