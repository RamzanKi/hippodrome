import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    @Disabled
    @Timeout(value = 21, unit = TimeUnit.SECONDS)
    void mainTest() throws Exception {
        Main.main(new String[0]);
    }
}
