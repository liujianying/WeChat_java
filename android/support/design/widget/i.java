package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class i {
    private static Method fa;
    private static boolean fb;
    private static Field fc;
    private static boolean fd;

    static boolean a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!fb) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                fa = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            fb = true;
        }
        if (fa != null) {
            try {
                fa.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    static boolean b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!fd) {
            try {
                Field declaredField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                fc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            fd = true;
        }
        if (fc != null) {
            try {
                fc.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
