package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.b.b;
import android.util.TypedValue;

final class al {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final ThreadLocal<TypedValue> Wn = new ThreadLocal();
    static final int[] Wo = new int[]{16843518};
    static final int[] Wp = new int[]{-16842919, -16842908};
    private static final int[] Wq = new int[1];
    static final int[] bh = new int[]{16842912};
    static final int[] gc = new int[]{-16842910};

    public static int m(Context context, int i) {
        Wq[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, Wq);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList n(Context context, int i) {
        Wq[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, Wq);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int o(Context context, int i) {
        ColorStateList n = n(context, i);
        if (n != null && n.isStateful()) {
            return n.getColorForState(gc, n.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) Wn.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            Wn.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return a(context, i, typedValue.getFloat());
    }

    static int a(Context context, int i, float f) {
        int m = m(context, i);
        return b.o(m, Math.round(((float) Color.alpha(m)) * f));
    }
}
