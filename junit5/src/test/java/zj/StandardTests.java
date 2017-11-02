package zj;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("beforeEach");
    }

    @Test
    void succeedingTest() {
        System.out.println("real test method");
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("after all");
    }

}