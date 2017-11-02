package zj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * DisplayName可以定义执行结果展示时的效果 ， 可以是文本甚至是emoji
 */
@DisplayName("A special test case")
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

}