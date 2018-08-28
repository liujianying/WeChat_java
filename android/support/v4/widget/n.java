package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class n {
    private static Field AX;

    static {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            AX = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
    }

    static void a(PopupWindow popupWindow, boolean z) {
        if (AX != null) {
            try {
                AX.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
            }
        }
    }
}
