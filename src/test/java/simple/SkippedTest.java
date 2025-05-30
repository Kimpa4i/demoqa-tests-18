package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Simple")
public class SkippedTest {
    @Test
    @Disabled("Reason 1")
    void test1() {
        assertTrue(false);
    }


    @Test
    @Disabled("Reason 2")
    void test2() {
        assertTrue(false);
    }


}


        
