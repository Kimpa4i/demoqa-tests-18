import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Here is Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Here is After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Here is Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Here is After Each");
    }


    @Test
    public void firstTest() {
        System.out.println("Here is First Test");
    }

    @Test
    public void secondTest() {
        System.out.println("Here is Second Test");
    }

}
