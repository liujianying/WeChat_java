package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class ae extends Drawable {
    float Tl;
    private final RectF Tm;
    private final Rect Tn;
    float To;
    boolean Tp = false;
    boolean Tq = true;
    final Paint cN;
    private PorterDuffColorFilter jM;
    private ColorStateList kI;
    private Mode kJ;

    public ae(int i, float f) {
        this.Tl = f;
        this.cN = new Paint(5);
        this.cN.setColor(i);
        this.Tm = new RectF();
        this.Tn = new Rect();
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.cN;
        if (this.jM == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.jM);
            obj = 1;
        }
        canvas.drawRoundRect(this.Tm, this.Tl, this.Tl, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    final void h(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.Tm.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.Tn.set(rect);
        if (this.Tp) {
            float c = af.c(this.To, this.Tl, this.Tq);
            this.Tn.inset((int) Math.ceil((double) af.d(this.To, this.Tl, this.Tq)), (int) Math.ceil((double) c));
            this.Tm.set(this.Tn);
        }
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.Tn, this.Tl);
    }

    public final void setAlpha(int i) {
        this.cN.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.kI = colorStateList;
        this.jM = b(this.kI, this.kJ);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.kJ = mode;
        this.jM = b(this.kI, this.kJ);
        invalidateSelf();
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.kI == null || this.kJ == null) {
            return false;
        }
        this.jM = b(this.kI, this.kJ);
        return true;
    }

    public final boolean isStateful() {
        return (this.kI != null && this.kI.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
