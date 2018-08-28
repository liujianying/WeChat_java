package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class d extends Drawable implements Callback, c, l {
    static final Mode jK = Mode.SRC_IN;
    private boolean jO;
    Drawable mDrawable;
    private int ru;
    private Mode rv;
    private boolean rw;
    a rx;

    protected static abstract class a extends ConstantState {
        int jA;
        ColorStateList kI = null;
        Mode kJ = d.jK;
        ConstantState ry;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.jA = aVar.jA;
                this.ry = aVar.ry;
                this.kI = aVar.kI;
                this.kJ = aVar.kJ;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.ry != null ? this.ry.getChangingConfigurations() : 0) | this.jA;
        }
    }

    private static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        this.rx = aVar;
        if (this.rx != null && this.rx.ry != null) {
            j(a(this.rx.ry, resources));
        }
    }

    d(Drawable drawable) {
        this.rx = bE();
        j(drawable);
    }

    protected Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.rx != null ? this.rx.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!bF() || this.rx == null) ? null : this.rx.kI;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return d(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.rx != null) {
            if ((this.rx.ry != null ? 1 : null) != null) {
                this.rx.jA = getChangingConfigurations();
                return this.rx;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.jO && super.mutate() == this) {
            this.rx = bE();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.rx != null) {
                this.rx.ry = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.jO = true;
        }
        return this;
    }

    a bE() {
        return new b(this.rx);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.rx.kI = colorStateList;
        d(getState());
    }

    public void setTintMode(Mode mode) {
        this.rx.kJ = mode;
        d(getState());
    }

    private boolean d(int[] iArr) {
        if (!bF()) {
            return false;
        }
        ColorStateList colorStateList = this.rx.kI;
        Mode mode = this.rx.kJ;
        if (colorStateList == null || mode == null) {
            this.rw = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.rw && colorForState == this.ru && mode == this.rv) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.ru = colorForState;
        this.rv = mode;
        this.rw = true;
        return true;
    }

    public final Drawable bD() {
        return this.mDrawable;
    }

    public final void j(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.rx != null) {
                this.rx.ry = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean bF() {
        return true;
    }
}
