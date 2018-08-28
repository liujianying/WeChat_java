package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class aa {
    private static Field vM;
    private static boolean vN;
    private static Field vO;
    private static boolean vP;

    static int S(View view) {
        if (!vN) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                vM = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            vN = true;
        }
        if (vM != null) {
            try {
                return ((Integer) vM.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int T(View view) {
        if (!vP) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                vO = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            vP = true;
        }
        if (vO != null) {
            try {
                return ((Integer) vO.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
