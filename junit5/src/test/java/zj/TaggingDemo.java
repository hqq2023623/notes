package zj;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * 给测试类和方法打上标签，用来进行过滤和执行
 */
@Tag("fast")
@Tag("model")
class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }

}