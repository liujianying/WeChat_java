package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class b {
    static Method rq;
    static boolean rr;
    private static Method rs;
    private static boolean rt;

    public static int i(Drawable drawable) {
        if (!rt) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                rs = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            rt = true;
        }
        if (rs != null) {
            try {
                return ((Integer) rs.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                rs = null;
            }
        }
        return -1;
    }
}
