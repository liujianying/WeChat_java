package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class d {
    private static Field yM;
    private static boolean yN;

    static Drawable a(CompoundButton compoundButton) {
        if (!yN) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                yM = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            yN = true;
        }
        if (yM != null) {
            try {
                return (Drawable) yM.get(compoundButton);
            } catch (IllegalAccessException e2) {
                yM = null;
            }
        }
        return null;
    }
}
