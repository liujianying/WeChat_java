package com.tencent.mm.ui.chatting.b.a;

import com.tencent.mm.ui.chatting.b.u;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    public static class a implements u {
    }

    Class<? extends u> cwo() default a.class;
}
