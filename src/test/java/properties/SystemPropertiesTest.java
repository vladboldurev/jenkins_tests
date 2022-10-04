package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("systemProprties")
public class SystemPropertiesTest {

    @Test
    void systemTest() {
        String browser = System.getProperty("browser");
        System.out.println("browser: " + browser);
        System.out.println(System.getProperty("any_text"));
    }
}
