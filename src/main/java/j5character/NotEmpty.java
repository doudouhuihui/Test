package j5character;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2020-03-19.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotEmpty {
     String msg() default "";
     int minLen() default 0;
     int maxLen() default Integer.MAX_VALUE;


}
