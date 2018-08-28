package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class ap {
    public final TypedArray Ww;
    private final Context mContext;

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    private ap(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.Ww = typedArray;
    }

    public final Drawable getDrawable(int i) {
        if (this.Ww.hasValue(i)) {
            int resourceId = this.Ww.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.eJ().a(this.mContext, resourceId, false);
            }
        }
        return this.Ww.getDrawable(i);
    }

    public final Drawable bP(int i) {
        if (this.Ww.hasValue(i)) {
            int resourceId = this.Ww.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.eJ().a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    public final CharSequence getText(int i) {
        return this.Ww.getText(i);
    }

    public final boolean getBoolean(int i, boolean z) {
        return this.Ww.getBoolean(i, z);
    }

    public final int getInt(int i, int i2) {
        return this.Ww.getInt(i, i2);
    }

    public final int bQ(int i) {
        return this.Ww.getColor(i, -1);
    }

    public final int getDimensionPixelOffset(int i, int i2) {
        return this.Ww.getDimensionPixelOffset(i, i2);
    }

    public final int getDimensionPixelSize(int i, int i2) {
        return this.Ww.getDimensionPixelSize(i, i2);
    }

    public final int getLayoutDimension(int i, int i2) {
        return this.Ww.getLayoutDimension(i, i2);
    }

    public final int getResourceId(int i, int i2) {
        return this.Ww.getResourceId(i, i2);
    }

    public final boolean hasValue(int i) {
        return this.Ww.hasValue(i);
    }
}
