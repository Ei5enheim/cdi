package com.jee.cdi.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Repeatable(GeneratorV2Container.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface GeneratorV2 {
    NumberOfDigits value() default NumberOfDigits.THIRTEEN;
}

