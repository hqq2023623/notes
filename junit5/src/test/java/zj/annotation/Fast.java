package zj.annotation;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 给方法和类打标签，用于对测试方法的过滤和执行，一般新建一个annotation再打上标签也可以达到效果，而不用复制 @Tag
 * @author lzj
 * @date 2017/11/3
 **/
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
