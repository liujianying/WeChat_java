package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class b {
    private static Method tc;

    static {
        try {
            tc = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String a(Locale locale) {
        try {
            return ((Locale) tc.invoke(null, new Object[]{locale})).getScript();
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e2) {
        }
        return locale.getScript();
    }
}
