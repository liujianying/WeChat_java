package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class c {
    private static Method tc;
    private static Method td;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                td = cls.getMethod("getScript", new Class[]{String.class});
                tc = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            td = null;
            tc = null;
        }
    }

    public static String a(Locale locale) {
        String b = b(locale);
        if (b != null) {
            return getScript(b);
        }
        return null;
    }

    private static String getScript(String str) {
        try {
            if (td != null) {
                return (String) td.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (tc != null) {
                return (String) tc.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return locale2;
    }
}
