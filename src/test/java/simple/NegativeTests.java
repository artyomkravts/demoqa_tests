package simple;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@Tag("simple")
public class NegativeTests {

    @Test
    public void test5() {
        fail();
    }

    @Test
    public void test1() {
        assertTrue(false);
    }

    @Test
    public void test2() {
        assertTrue(false);
    }

    @Test
    public void test3() {
        assertTrue(false);
    }

    @Test
    public void test4() {
        assertTrue(false);
    }
}
