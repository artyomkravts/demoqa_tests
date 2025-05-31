package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
@Disabled
public class SkippedTests {

    @Test
    public void test5() {
        assertTrue(true);
    }

    @Test
    public void test1() {
        assertTrue(true);
    }

}
